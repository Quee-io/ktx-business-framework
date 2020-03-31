package io.quee.api.develop.store

import io.quee.api.develop.identity.Identity
import io.quee.api.develop.shared.model.PageData
import java.io.Serializable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Fri Feb, 2020**
 */
interface StoreQuery<ID : Serializable, I : Identity<ID>> {
    fun find(uuid: String): I?
    fun exist(uuid: String): Boolean
    fun all(): List<I>
    fun all(page: Int, size: Int): PageData<I>
    fun allByUuids(uuids: List<String>): Iterable<I>
}