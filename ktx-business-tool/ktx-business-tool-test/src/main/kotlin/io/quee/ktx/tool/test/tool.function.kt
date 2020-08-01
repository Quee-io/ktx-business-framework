package io.quee.ktx.tool.test

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Thursday **16**, July 2020**
 */
val mapper = jacksonObjectMapper()

inline fun <reified T> Map<String, Any>.toObject(): T {
    return convert()
}

fun <T> T.toMap(): Map<String, Any> {
    return convert()
}

inline fun <T, reified R> T.convert(): R {
    val json = mapper.writeValueAsString(this)
    return mapper.readValue(json, R::class.java)
}
