package io.quee.ktx.develop.action.usecase.func

import io.quee.ktx.develop.shared.error.Error
import io.quee.ktx.develop.usecase.model.UseCaseRequest
import javax.validation.ConstraintViolation

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 22, **Sat Aug, 2020**
 * Project *quee-api-parent* [Quee.IO]
 */
interface ErrorMapper {
    fun <RQ : UseCaseRequest> ConstraintViolation<RQ>.mapToError(): Error
}