package io.quee.ktx.develop.store

import io.quee.ktx.develop.identity.Identity
import io.quee.ktx.develop.shared.func.Updater
import java.io.Serializable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Fri Feb, 2020**
 */
interface StoreIdentityUpdater<ID : Serializable, I : Identity<ID>> : Updater<I>