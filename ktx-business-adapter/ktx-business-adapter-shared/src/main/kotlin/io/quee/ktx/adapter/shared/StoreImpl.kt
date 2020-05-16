package io.quee.ktx.adapter.shared

import io.quee.ktx.adapter.shared.query.StoreQueryImpl
import io.quee.ktx.adapter.shared.respository.MainRepository
import io.quee.ktx.develop.identity.Identity
import io.quee.ktx.develop.store.Store
import io.quee.ktx.develop.store.StoreQuery
import java.io.Serializable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **29**, April 2020**
 */
abstract class StoreImpl<ID : Serializable, I : Identity<ID>, E : I>(
        private val mainRepository: MainRepository<ID, E>
) : Store<ID, I> {
    override fun ID.delete() = mainRepository.deleteById(this)
    override fun I.delete() = mainRepository.delete(map())
    abstract fun I.map(): E
    override fun I.save(): I = mainRepository.save(this.map())
    override fun List<I>.save(): Iterable<I> = mainRepository.saveAll(map {
        it.map()
    })

    override fun List<I>.deleteAll() {
        with(mainRepository) {
            deleteAll(map {
                it.map()
            })
        }
    }

    override fun List<ID>.deleteAllByIds() = forEach {
        mainRepository.deleteById(it)
    }

    override val storeQuery: StoreQuery<ID, I> = StoreQueryImpl(mainRepository)

}
