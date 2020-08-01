package io.quee.ktx.tool.test.function

import java.io.InputStream
import kotlin.reflect.KClass

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **15**, July 2020**
 */
interface DataParser {
    fun <T : Any> String.parse(clazz: KClass<T>): T
    fun <T : Any> InputStream.parse(clazz: KClass<T>): T
    fun <T : Any> T.write(): String
}