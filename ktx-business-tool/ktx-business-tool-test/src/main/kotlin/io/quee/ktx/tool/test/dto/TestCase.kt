package io.quee.ktx.tool.test.dto

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **15**, July 2020**
 */
data class TestCase(
        val mapping: String,
        val responseType: ResponseType,
        val requestType: RequestType = RequestType.POST,
        val request: MutableMap<String, Any?>,
        val response: MutableMap<String, Any?>,
        val extraResponse: MutableMap<String, Any>? = null,
        val autoHeader: Boolean = true,
        val autoBankSignature: Boolean = true,
        val headers: List<KeyValue<String, String>> = ArrayList(),
        val signature: MutableMap<String, Any?>? = null
)