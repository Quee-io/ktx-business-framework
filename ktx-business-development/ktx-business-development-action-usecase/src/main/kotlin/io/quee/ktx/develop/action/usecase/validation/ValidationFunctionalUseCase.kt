package io.quee.ktx.develop.action.usecase.validation

import io.quee.ktx.develop.action.usecase.ActionableFunctionalUseCase
import io.quee.ktx.develop.usecase.UseCaseValidator
import io.quee.ktx.develop.usecase.model.UseCaseRequest
import io.quee.ktx.develop.usecase.model.UseCaseResponse

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **07**, **Sat Mar, 2020**
 */
abstract class ValidationFunctionalUseCase<RQ : UseCaseRequest, RS : UseCaseResponse>
    : ActionableFunctionalUseCase<RQ, RS>() {
    final override fun RQ.before() {
        UseCaseValidator.newInstance<RQ>().run {
            validate()
        }
        extraValidation()
    }

    open fun RQ.extraValidation() {
        // do nothing
    }

    override fun RQ.after(response: RS) {
        // do nothing
    }
}