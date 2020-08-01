package io.quee.ktx.tool.test.dsl

import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Sunday **19**, July 2020**
 */

inline fun <reified T> Gson.fromJson(json: String): T {
    return fromJson(json, T::class.java)
}

inline fun <reified T> Gson.fromJson(json: JsonObject): T {
    return fromJson(json, T::class.java)
}