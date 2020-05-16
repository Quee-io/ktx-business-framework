package io.quee.ktx.develop.usecase

import io.quee.ktx.develop.shared.error.Error
import io.quee.ktx.develop.shared.error.SharedException
import java.util.*

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Sat Aug, 2019**
 */
class UseCaseException(errors: List<Error> = ArrayList()) : SharedException(errors = errors)