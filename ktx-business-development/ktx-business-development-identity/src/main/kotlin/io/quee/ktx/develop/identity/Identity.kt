package io.quee.ktx.develop.identity

import java.io.Serializable
import java.time.LocalDateTime

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
interface Identity<ID : Serializable> : Serializable {
    val uuid: ID?
    val creationDate: LocalDateTime
}