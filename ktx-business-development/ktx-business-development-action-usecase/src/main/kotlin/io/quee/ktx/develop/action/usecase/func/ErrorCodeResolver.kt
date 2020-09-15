package io.quee.ktx.develop.action.usecase.func

/**
 * Created By [*Ibrahim AlTamimi *](https://www.linkedin.com/in/iloom/)
 * Created At 22, **Sat Aug, 2020**
 * Project *quee-api-parent* [Quee.IO]
 */
interface ErrorCodeResolver {
    fun String.resolve(): String
}