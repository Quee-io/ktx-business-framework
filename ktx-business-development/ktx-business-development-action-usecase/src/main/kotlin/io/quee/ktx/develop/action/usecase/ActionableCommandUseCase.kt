package io.quee.ktx.develop.action.usecase

import io.quee.ktx.develop.action.usecase.action.Actionable
import io.quee.ktx.develop.usecase.model.UseCaseRequest
import io.quee.ktx.develop.usecase.type.CommandUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **07**, **Sat Mar, 2020**
 */
abstract class ActionableCommandUseCase<RQ : UseCaseRequest> : CommandUseCase<RQ>, Actionable<RQ> {
    final override fun RQ.execute() {
        before()
        realExecute()
        after()
    }

    abstract fun RQ.realExecute()
}