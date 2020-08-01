package io.quee.ktx.develop.reactive.usecase

import io.quee.ktx.develop.usecase.model.UseCaseRequest
import io.quee.ktx.develop.usecase.model.UseCaseResponse
import io.reactivex.Observable

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
@FunctionalInterface
interface RxUseCase<RQ, RS> where RQ : UseCaseRequest, RS : UseCaseResponse {
    fun process(data: RQ): Observable<RS>
}