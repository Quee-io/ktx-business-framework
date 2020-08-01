package io.quee.ktx.tool.test.regex

import io.quee.ktx.tool.test.dto.TestClassData

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **15**, July 2020**
 */
interface RegexReplacer {
    fun String.replace(): TestClassData
}