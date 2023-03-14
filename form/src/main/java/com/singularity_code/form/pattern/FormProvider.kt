package com.singularity_code.form.pattern

import com.singularity_code.form.util.ID
import com.singularity_code.form.util.ValidationStatus

/**
 * Implement this pattern as a contract for class that provide a form.
 * ex:
 * ```
 * class FragmentA : FormProvider {
 *
 *  private val _form by lazy {
 *      form("userForm").apply{
 *
 *          // add item and rule
 *          ...
 *
 *      }
 *  }
 *
 *  override fun getForm(): Form = _form
 *
 *  override fun onCreateView(savedInstance: Bundle) {
 *      super.onCreateView(savedInstance)
 *
 *      // this action will automatically bind to getForm().onValidationResult(..)
 *      onValidationResult{ formItem ->
 *          ...
 *      }
 *  }
 *
 * }
 * ```
 */
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