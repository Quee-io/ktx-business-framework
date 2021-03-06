package io.quee.ktx.develop.usecase.type

import io.quee.ktx.develop.usecase.model.UseCaseRequest
import io.quee.ktx.develop.usecase.model.UseCaseResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
@FunctionalInterface
interface FunctionalUseCase<RQ, RS> where RQ : UseCaseRequest, RS : UseCaseResponse {
    fun RQ.process(): RS
}