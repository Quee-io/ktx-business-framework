package io.quee.ktx.tool.test

import io.quee.ktx.tool.test.dto.TestClassData
import io.quee.ktx.tool.test.parser.JacksonDataParser
import io.quee.ktx.tool.test.replacer.DefaultRegexReplacer

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Thursday **16**, July 2020**
 */
class SampleApp

fun main(args: Array<String>) {
    val dataParser = JacksonDataParser()
    val regexReplacer = DefaultRegexReplacer(dataParser)
    val testClassData = with(regexReplacer) {
        dataParser.run {
            val testClassData = SampleApp::class.java.classLoader.getResourceAsStream("sample.json")!!.parse(TestClassData::class)
            testClassData.write()
        }.replace()
    }
    println(testClassData)
}