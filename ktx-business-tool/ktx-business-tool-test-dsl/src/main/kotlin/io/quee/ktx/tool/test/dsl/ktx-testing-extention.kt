package io.quee.ktx.tool.test.dsl

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.quee.ktx.tool.test.KtxTestingTool
import io.quee.ktx.tool.test.dto.TestCase
import io.quee.ktx.tool.test.dto.TestClassData
import org.junit.jupiter.api.DynamicTest
import kotlin.reflect.KClass

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Sunday **19**, July 2020**
 */
val gson = Gson()

fun <RS : Any> KtxTestingTool.run(
        jsonObject: JsonObject,
        clazz: KClass<RS>,
        successCall: (TestCase, RS?) -> Unit,
        failCall: (TestCase, Throwable) -> Unit
): List<DynamicTest> {
    return run(
            jsonObject.toTestData(),
            clazz,
            successCall,
            failCall
    )
}

fun JsonObject.toTestData(): TestClassData = gson.fromJson(this)