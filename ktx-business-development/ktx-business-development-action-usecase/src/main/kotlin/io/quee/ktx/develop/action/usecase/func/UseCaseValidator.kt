package io.quee.ktx.develop.action.usecase.func

import io.quee.ktx.develop.shared.error.Error
import io.quee.ktx.develop.usecase.UseCaseException
import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator as JavaXValidator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
object UseCaseValidator {
    private val validator: JavaXValidator = Validation.buildDefaultValidatorFactory().validator
    fun <T> T.validate() {
        val violations = validator.validate(this)
        if (violations.isNotEmpty()) {
            val errors: List<Error> = violations
                    .map { createErrorMessage(it) }
            throw UseCaseException(errors)
        }
    }

    private fun <T> createErrorMessage(violation: ConstraintViolation<T>): Error {
        val propertyPath = violation.propertyPath
        val message = violation.message
        val nodes = propertyPath.toList()
        return if (nodes.isNotEmpty()) {
            Error(nodes[nodes.size - 1].name, message)
        } else Error(message, propertyPath.toString())
    }
}