package io.quee.api.develop.store

import io.quee.api.develop.identity.Identity
import io.quee.api.develop.shared.func.Creator
import java.io.Serializable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Fri Feb, 2020**
 */
interface StoreIdentityCreator<ID : Serializable, I : Identity<ID>> : Creator<I> {
    fun ID.uuid(): StoreIdentityCreator<ID, I>
}