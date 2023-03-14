/**
 * Design and developed by : St. Ayudha Junior.
 * [mail](stefanus.ayudha@gmail.com)
 * [github](https://github.com/stefanusayudha)
 */
package com.singularity_code.form.util

import com.singularity_code.form.pattern.FormRule

data class FormRuleImpl<T>(
    override val errorMessage: String,
    override val rule: (T) -> Boolean
) : FormRule<T>

fun <T> formRule(
    errorMessage: String,
    rule: (T) -> Boolean
) = FormRuleImpl(
    errorMessage = errorMessage,
    rule = rule
)