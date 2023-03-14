/**
 * Design and developed by : St. Ayudha Junior.
 * [mail](stefanus.ayudha@gmail.com)
 * [github](https://github.com/stefanusayudha)
 */
package com.singularity_code.form.util

sealed class ValidationStatus<T>

data class Invalid<T>(
    val msg: String
) : ValidationStatus<T>()

data class Valid<T>(
    val value: T
) : ValidationStatus<T>()

data class Unset<T>(
    private val value: Any? = null
) : ValidationStatus<T>()
