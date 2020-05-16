package io.quee.ktx.develop.action.usecase.action

import io.quee.ktx.develop.usecase.model.UseCaseRequest
import io.quee.ktx.develop.usecase.model.UseCaseResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **07**, **Sat Mar, 2020**
 */
interface ActionableWithResponse<RQ : UseCaseRequest, RS : UseCaseResponse> {
    fun RQ.before()
    fun RQ.after(response: RS)
}