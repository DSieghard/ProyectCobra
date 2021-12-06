package com.sgtst.proyect_cobra
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class LoginValidation

    (private val context: Context) {

    fun isInputEditTextFilled(textInputEditText: EditText, textInputLayout: TextView, message: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if(value.isEmpty()) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText)
            return false
        } else {
            textInputLayout.error = false.toString()
        }
        return true
    }


    fun isInputEditTextEmail(textInputEditText: EditText, textInputLayout: TextView, message: String): Boolean {
        val value = textInputEditText.text.toString().trim()
        if(value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText)
            return false
        } else {
            textInputLayout.error = false.toString()
        }
        return true
    }

    fun isInputEditTextMatches(textInputEditText1: EditText, textInputEditText2: EditText, textInputLayout: TextView, message: String): Boolean {
        val value1 = textInputEditText1.text.toString().trim()
        val value2 = textInputEditText2.text.toString().trim()
        if (!value1.contentEquals(value2)) {
            textInputLayout.error = message
            hideKeyboardFrom(textInputEditText2)
            return false
        } else {
            textInputLayout.error = false.toString()
        }
        return true


    }

    private fun hideKeyboardFrom(view: View) {
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }
}