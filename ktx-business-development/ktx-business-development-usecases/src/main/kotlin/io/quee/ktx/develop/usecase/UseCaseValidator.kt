package io.quee.ktx.develop.usecase

import io.quee.ktx.develop.shared.error.Error
import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator as JavaXValidator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
class UseCaseValidator<T> private constructor() {
    private val validator: JavaXValidator = Validation.buildDefaultValidatorFactory().validator
    fun T.validate() {
        val violations = validator.validate(this)
        if (violations.isNotEmpty()) {
            val errors: List<Error> = violations
                    .map { createErrorMessage(it) }
            throw UseCaseException(errors)
        }
    }

    private fun createErrorMessage(violation: ConstraintViolation<T>): Error {
        val propertyPath = violation.propertyPath
        val message = violation.message
        val nodes = propertyPath.toList()
        return if (nodes.isNotEmpty()) {
            Error(nodes[nodes.size - 1].name, message)
        } else Error(message, propertyPath.toString())
    }

    companion object {
        fun <T> newInstance(): UseCaseValidator<T> {
            return UseCaseValidator()
        }
    }

}