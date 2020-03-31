package io.quee.api.develop.action.usecase

import io.quee.api.develop.action.usecase.action.Actionable
import io.quee.api.develop.usecase.model.UseCaseRequest
import io.quee.api.develop.usecase.type.CommandUseCase

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **07**, **Sat Mar, 2020**
 */
/**
 *
 * @param RQ : UseCaseRequest
 */
abstract class ActionableCommandUseCase<RQ : UseCaseRequest> : CommandUseCase<RQ>, Actionable<RQ> {
    /**
     *
     * @receiver RQ
     */
    final override fun RQ.execute() {
        before()
        realExecute()
        after()
    }

    /**
     *
     * @receiver RQ
     */
    abstract fun RQ.realExecute()
}