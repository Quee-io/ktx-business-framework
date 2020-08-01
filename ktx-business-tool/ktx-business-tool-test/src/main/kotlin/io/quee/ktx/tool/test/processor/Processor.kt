package io.quee.ktx.tool.test.processor

import io.quee.ktx.tool.test.dto.TestCase
import kotlin.reflect.KClass

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **15**, July 2020**
 */
interface Processor {
    fun <RS : Any> process(
            testCase: TestCase,
            clazz: KClass<RS>,
            successCall: (TestCase, RS?) -> Unit,
            failCall: (TestCase, Throwable) -> Unit
    )
}