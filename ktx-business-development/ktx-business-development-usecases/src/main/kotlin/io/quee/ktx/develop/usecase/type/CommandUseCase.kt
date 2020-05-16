package io.quee.ktx.develop.usecase.type

import io.quee.ktx.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
@FunctionalInterface
interface CommandUseCase<RQ : UseCaseRequest> {
    fun RQ.execute()
}