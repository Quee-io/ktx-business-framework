package io.quee.ktx.tool.json.dsl

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Sunday **19**, July 2020**
 */


/**
 * Creates a [JsonObject], calls the provided function on it, and returns it
 */
fun ktxJsonObject(init: KtxJsonObjectBuilder.() -> Unit): JsonObject {
    val builder = KtxJsonObjectBuilder()
    builder.init()
    return builder.build()
}

/**
 * Returns a [JsonArray] with the elements provided.
 *
 * Items provided must either be [Boolean], [Char], [String], [Number], or [JsonElement]
 */
fun <T> ktxJsonArray(vararg item: T?): JsonArray {
    return item.toList().toJsonArray()
}

/**
 * Converts a [List] to a [JsonArray]
 */
fun <T> List<T>.toJsonArray(): JsonArray {
    val jsonArray = JsonArray()
    this.forEach {
        when (it) {
            is Boolean -> jsonArray.add(it)
            is Char -> jsonArray.add(it)
            is String -> jsonArray.add(it)
            is Number -> jsonArray.add(it)
            is JsonElement -> jsonArray.add(it)
            is List<*> -> jsonArray.addAll(ktxJsonArray(it))
            is Map<*, *> -> jsonArray.add((it as Map<*, *>).toJsonObject())
            null -> jsonArray.add(JsonNull.INSTANCE)
            else -> jsonArray.add(it.toString())
        }
    }
    return jsonArray
}

/**
 * Alternative syntax for [List].[toJsonArray]. Converts the [List] into a [JsonArray].
 */
fun <T> ktxJsonArray(list: List<T>) = list.toJsonArray()

/**
 * Converts a [Map] to a [JsonObject]
 */
fun <X, Y> Map<X, Y>.toJsonObject(): JsonObject {
    return ktxJsonObject {
        forEach { (t, u) -> t.toString() to u }
    }
}