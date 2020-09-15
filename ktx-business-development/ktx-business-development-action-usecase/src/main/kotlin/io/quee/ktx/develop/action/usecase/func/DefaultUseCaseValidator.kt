package io.quee.ktx.develop.action.usecase.func

import io.quee.ktx.develop.shared.error.Error
import io.quee.ktx.develop.usecase.UseCaseException
import io.quee.ktx.develop.usecase.model.UseCaseRequest
import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator as JavaXValidator

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
open class DefaultUseCaseValidator internal constructor(
        private val validator: JavaXValidator = Validation.buildDefaultValidatorFactory().validator,
        private val errorMapper: ErrorMapper = DefaultErrorMapper()
) : UseCaseValidator {
    override fun <RQ : UseCaseRequest> RQ.validate() {
        val violations = validator.run {
            validate(this@validate)
        }
        when {
            violations.isNotEmpty() -> {
                val errors: List<Error> = with(errorMapper) {
                    violations.map {
                        it.mapToError()
                    }
                }
                throw UseCaseException(errors)
            }
        }
    }

    companion object {
        val instance = create()

        fun create(
                validator: JavaXValidator = Validation.buildDefaultValidatorFactory().validator,
                errorMapper: ErrorMapper = DefaultErrorMapper()
        ): UseCaseValidator {
            return DefaultUseCaseValidator(
                    validator, errorMapper
            )
        }
    }

    class DefaultErrorMapper : ErrorMapper {
        override fun <RQ : UseCaseRequest> ConstraintViolation<RQ>.mapToError(): Error {
            val propertyPath = propertyPath
            val message = message
            val nodes = propertyPath.toList()
            return if (nodes.isNotEmpty()) {
                Error(nodes[nodes.size - 1].name, message)
            } else Error(message, propertyPath.toString())
        }
    }
}