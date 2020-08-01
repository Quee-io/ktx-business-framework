package io.quee.ktx.tool.test.dto

import org.springframework.web.reactive.function.client.WebClientResponseException
import kotlin.reflect.KClass

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **15**, July 2020**
 */
enum class ResponseType(val responseException: KClass<out WebClientResponseException>?) {
    SUCCESS(null),
    BAD_REQUEST(WebClientResponseException.BadRequest::class),
    NOT_FOUND(WebClientResponseException.NotFound::class),
    UN_AUTHORIZED(WebClientResponseException.Unauthorized::class),
    NOT_ACCEPTABLE(WebClientResponseException.NotAcceptable::class)

}