package io.quee.ktx.tool.test.parser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.quee.ktx.tool.test.function.DataParser
import java.io.InputStream
import kotlin.reflect.KClass

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **15**, July 2020**
 */
class JacksonDataParser(
        private val objectMapper: ObjectMapper = jacksonObjectMapper()
) : DataParser {
    override fun <T : Any> String.parse(clazz: KClass<T>): T = objectMapper.readValue(this, clazz.java)

    override fun <T : Any> InputStream.parse(clazz: KClass<T>): T = objectMapper.readValue(this, clazz.java)

    override fun <T : Any> T.write(): String = objectMapper.writeValueAsString(this)
}