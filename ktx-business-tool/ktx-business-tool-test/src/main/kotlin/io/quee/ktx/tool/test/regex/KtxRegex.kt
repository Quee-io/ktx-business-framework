package io.quee.ktx.tool.test.regex

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **15**, July 2020**
 */
interface KtxRegex {
    val regex: Regex
    val preProcess: Boolean

    fun String.isMatch(): Boolean
    fun String.replace(transformer: (MatchResult) -> String): String
}