package io.quee.ktx.develop.action.usecase.validation

import io.quee.ktx.develop.action.usecase.ActionableCommandUseCase
import io.quee.ktx.develop.action.usecase.func.UseCaseValidator
import io.quee.ktx.develop.usecase.model.UseCaseRequest

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **07**, **Sat Mar, 2020**
 */
abstract class ValidationCommandUseCase<RQ : UseCaseRequest> : ActionableCommandUseCase<RQ>() {
    final override fun RQ.before() {
        UseCaseValidator.run {
            validate()
        }
        extraValidation()
    }

    open fun RQ.extraValidation() {
        // do nothing
    }


    override fun RQ.after() {
        // do nothing
    }
}