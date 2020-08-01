package io.quee.ktx.tool.http

import io.netty.channel.ChannelOption
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.netty.http.client.HttpClient
import reactor.netty.tcp.TcpClient
import kotlin.reflect.KClass

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Thursday **16**, July 2020**
 */
class HttpRequestProcessor private constructor(private val rootUrl: String) {


    private val webClient: WebClient


    fun <T, RS : Any> postBlocking(request: RequestData<T>,
                                   responseClass: KClass<RS>,
                                   subscription: RS?.() -> Unit,
                                   errorHandler: Throwable.() -> Unit
    ) {
        postBlocking(request.body, request.mapping, request.headers, responseClass, subscription, errorHandler)
    }

    fun <T, RS : Any> postBlocking(request: T,
                                   mapping: String,
                                   headers: List<Pair<String, Any?>>,
                                   responseClass: KClass<RS>,
                                   subscription: RS?.() -> Unit,
                                   errorHandler: Throwable.() -> Unit
    ) {
        try {
            val response = post(request, mapping, responseClass.java, headers)
                    .blockFirst()
            subscription(response)
        } catch (e: Throwable) {
            errorHandler(e)
        }
    }


    fun <T, RS : Any> patchBlocking(request: RequestData<T>,
                                    responseClass: KClass<RS>,
                                    subscription: RS?.() -> Unit,
                                    errorHandler: Throwable.() -> Unit
    ) {
        patchBlocking(request.body, request.mapping, request.headers, responseClass, subscription, errorHandler)
    }

    fun <T, RS : Any> patchBlocking(request: T,
                                    mapping: String,
                                    headers: List<Pair<String, Any?>>,
                                    responseClass: KClass<RS>,
                                    subscription: RS?.() -> Unit,
                                    errorHandler: Throwable.() -> Unit
    ) {
        try {
            val response = patch(request, mapping, responseClass.java, headers)
                    .blockFirst()
            subscription(response)
        } catch (e: Throwable) {
            errorHandler(e)
        }
    }

    fun <T, RS : Any> putBlocking(request: RequestData<T>,
                                  responseClass: KClass<RS>,
                                  subscription: RS?.() -> Unit,
                                  errorHandler: Throwable.() -> Unit
    ) {
        putBlocking(request.body, request.mapping, request.headers, responseClass, subscription, errorHandler)
    }

    fun <T, RS : Any> putBlocking(request: T,
                                  mapping: String,
                                  headers: List<Pair<String, Any?>>,
                                  responseClass: KClass<RS>,
                                  subscription: RS?.() -> Unit,
                                  errorHandler: Throwable.() -> Unit
    ) {
        try {
            val response = put(request, mapping, responseClass.java, headers)
                    .blockFirst()
            subscription(response)
        } catch (e: Throwable) {
            errorHandler(e)
        }
    }

    fun <T, RS> post(request: T,
                     mapping: String,
                     responseClass: Class<RS>,
                     headers: List<Pair<String, Any?>> = arrayListOf()
    ): Flux<RS> {
        val requestBodySpec = webClient.post()
                .uri("$rootUrl/$mapping")
        headers.forEach {
            requestBodySpec.header(it.first, it.second?.toString())
        }
        return requestBodySpec
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToFlux(responseClass)
    }

    fun <T, RS> patch(request: T,
                      mapping: String,
                      responseClass: Class<RS>,
                      headers: List<Pair<String, Any?>> = arrayListOf()
    ): Flux<RS> {
        val requestBodySpec = webClient.patch()
                .uri("$rootUrl/$mapping")
        headers.forEach {
            requestBodySpec.header(it.first, it.second?.toString())
        }
        return requestBodySpec
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToFlux(responseClass)
    }

    fun <T, RS> put(request: T,
                    mapping: String,
                    responseClass: Class<RS>,
                    headers: List<Pair<String, Any?>> = arrayListOf()
    ): Flux<RS> {
        val requestBodySpec = webClient.put()
                .uri("$rootUrl/$mapping")
        headers.forEach {
            requestBodySpec.header(it.first, it.second?.toString())
        }
        return requestBodySpec
                .body(BodyInserters.fromValue(request))
                .retrieve()
                .bodyToFlux(responseClass)
    }

    companion object {
        fun from(rootUrl: String): HttpRequestProcessor {
            return HttpRequestProcessor(rootUrl)
        }
    }

    init {
        val tcpClient = TcpClient.create()
                .option(ChannelOption.SO_KEEPALIVE, true)
        webClient = WebClient.builder()
                .clientConnector(ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .defaultHeader("Keep-Alive", "timeout=5")
                .build()
    }

}

data class RequestData<T>(
        val body: T?,
        val mapping: String,
        val headers: List<Pair<String, Any?>> = arrayListOf()
)