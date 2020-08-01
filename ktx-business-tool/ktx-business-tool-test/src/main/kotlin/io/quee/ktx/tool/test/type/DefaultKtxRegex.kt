package io.quee.ktx.tool.test.type

import io.quee.ktx.tool.test.regex.KtxRegex

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **15**, July 2020**
 */
open class DefaultKtxRegex(
        private val regexValue: String,
        override val preProcess: Boolean
) : KtxRegex {
    override val regex = regexValue.toRegex()

    override fun String.isMatch() = regex.matches(this)
    override fun String.replace(transformer: (MatchResult) -> String): String {
        require(isMatch()) {
            "Invalid input, $this didn't match $regexValue."
        }
        return ""
    }
}