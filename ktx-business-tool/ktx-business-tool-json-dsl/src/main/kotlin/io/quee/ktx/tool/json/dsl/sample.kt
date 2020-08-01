package io.quee.ktx.tool.json.dsl

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **02**, **Sun Aug, 2020**
 * Project **ktx-business-framework** [Quee.IO](https://quee.io/)
 */
val ktxJsonData = ktxJsonObject {
    "keyA" to "data"
    "keyProvider" to {
        "data"
    }
}

fun main() {
    println(ktxJsonData)
}