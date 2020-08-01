package io.quee.ktx.tool.json.dsl

import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Sunday **19**, July 2020**
 */

class KtxJsonObjectBuilder internal constructor() {

    private val jsonObject = JsonObject()

    /**
     * Add a property with the given key
     *
     * Syntax: "key" to value
     */
    infix fun <T> String.to(value: T?) {
        when (value) {
            is Boolean -> jsonObject.addProperty(this, value)
            is Char -> jsonObject.addProperty(this, value)
            is String -> jsonObject.addProperty(this, value)
            is Number -> jsonObject.addProperty(this, value)
            is JsonElement -> jsonObject.add(this, value)
            null -> jsonObject.add(this, JsonNull.INSTANCE)
            else -> jsonObject.addProperty(this, value.toString())
        }
    }

    /**
     * Add a property with the given key
     *
     * Syntax: "key" to {value provider}
     */
    infix fun <T> String.to(provider: () -> T?) {
        this to provider()
    }

    /**
     * Return the completed [JsonObject]
     */
    internal fun build(): JsonObject {
        return jsonObject
    }

}
