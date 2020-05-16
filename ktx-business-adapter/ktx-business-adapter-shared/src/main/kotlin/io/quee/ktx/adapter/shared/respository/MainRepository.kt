package io.quee.ktx.adapter.shared.respository

import io.quee.ktx.develop.identity.Identity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.io.Serializable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **29**, April 2020**
 */
@NoRepositoryBean
interface MainRepository<ID : Serializable, I : Identity<ID>> : JpaRepository<I, ID> {
    fun findByUuid(id: ID): I?
}