package io.quee.ktx.adapter.shared.query

import io.quee.ktx.adapter.shared.respository.MainRepository
import io.quee.ktx.adapter.shared.toPageData
import io.quee.ktx.develop.identity.Identity
import io.quee.ktx.develop.shared.model.PageData
import io.quee.ktx.develop.store.StoreQuery
import org.springframework.data.domain.PageRequest
import java.io.Serializable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **29**, April 2020**
 */
open class StoreQueryImpl<ID : Serializable, I : Identity<ID>, E : I>(
        private val mainRepository: MainRepository<ID, E>
) : StoreQuery<ID, I> {
    override fun find(uuid: ID): I? = mainRepository.findByUuid(uuid)
    override fun exist(uuid: ID): Boolean = mainRepository.existsById(uuid)
    override fun allByUuids(uuids: List<ID>): Iterable<I> = mainRepository.findAllById(uuids)
    override fun all(): List<I> = mainRepository.findAll()
    override fun all(page: Int, size: Int): PageData<I> = mainRepository.findAll(PageRequest.of(page, size)).toPageData()
}
