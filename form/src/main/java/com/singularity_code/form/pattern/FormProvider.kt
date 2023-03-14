package com.singularity_code.form.pattern

import com.singularity_code.form.util.ID
import com.singularity_code.form.util.ValidationStatus

interface FormProvider: Form {
    fun getForm() : Form

    override val id: String
        get() = getForm().id

    override val formItems: Map<ID, FormItem<*>>
        get() = getForm().formItems

    override val formRules: Map<ID, List<FormRule<*>>>
        get() = getForm().formRules

    override fun build(): Map<String, ValidationStatus<*>> {
        return getForm().build()
    }

    override fun <T> addItem(item: FormItem<T>) {
        return getForm().addItem(item)
    }

    override fun <T> addRule(id: String, formRule: FormRule<T>) {
        return getForm().addRule(id, formRule)
    }

    override fun <T> update(id: String, value: T) {
        return getForm().update(id, value)
    }

    override fun onValidationResult(block: (FormItem<*>) -> Unit) {
        getForm().onValidationResult(block)
    }

    override fun allIsValid(): Boolean {
        return getForm().allIsValid()
    }
}