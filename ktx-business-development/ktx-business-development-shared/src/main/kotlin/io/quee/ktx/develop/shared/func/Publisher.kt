package io.quee.ktx.develop.shared.func

/**
 * Created By [**Ibrahim Al-Tamimi **](https://www.linkedin.com/in/iloom/)<br></br>
 * Created At **Tue Oct, 2019**
 */
@FunctionalInterface
interface Publisher<T> {
    fun publish(event: T)
}