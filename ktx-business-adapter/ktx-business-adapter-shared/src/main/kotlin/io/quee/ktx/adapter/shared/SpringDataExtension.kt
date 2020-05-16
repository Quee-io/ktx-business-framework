package io.quee.ktx.adapter.shared

import io.quee.ktx.develop.shared.model.PageData
import org.springframework.data.domain.Page

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)
 * Created At **Wednesday **29**, April 2020**
 */
fun <I, E : I> Page<E>.toPageData(): PageData<I> {
    return PageData(content, numberOfElements, totalElements, totalPages, number, size)
}
