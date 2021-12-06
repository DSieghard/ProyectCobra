package com.sgtst.proyect_cobra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity(), View.OnClickListener{

    val activity = this@RegisterActivity

    private lateinit var passwordField: TextView
    private lateinit var passwordConfirmField: TextView
    private lateinit var usernameField: TextView
    private lateinit var emailField: TextView

    private lateinit var passwordEditText: EditText
    private lateinit var passwordConfirmEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText

    private lateinit var registerPassButton: Button
    private lateinit var backtoLoginButton: Button

    private lateinit var loginValidation: LoginValidation
    private lateinit var dataBaseHelper: DataBaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "Register Form"
        supportActionBar!!.hide()

        initViews()
        initListeners()
        initObjects()
    }

    private fun initViews() {
        passwordField = findViewById<View>(R.id.passwordField) as TextView
        passwordConfirmField = findViewById<View>(R.id.passwordConfirmField) as TextView
        usernameField = findViewById<View>(R.id.usernameText) as TextView
        emailField = findViewById<View>(R.id.emailTextField) as TextView

        passwordEditText = findViewById<View>(R.id.passwordEditText) as EditText
        passwordConfirmEditText = findViewById<View>(R.id.passwordConfirmTextEdit) as EditText
        usernameEditText = findViewById<View>(R.id.usernameTextEdit) as EditText
        emailEditText = findViewById<View>(R.id.emailEditText) as EditText

        registerPassButton = findViewById<View>(R.id.registerPassButton) as Button
        backtoLoginButton = findViewById<View>(R.id.backButton) as Button
    }

    private fun initListeners() {
        registerPassButton!!.setOnClickListener(this)
        backtoLoginButton!!.setOnClickListener(this)
    }

    private fun initObjects() {
        loginValidation = LoginValidation(activity)
        dataBaseHelper = DataBaseHelper(activity)
    }

    override fun onClick(v: View){
        when(v.id) {

            R.id.registerPassButton -> postDataToSQL()
            R.id.backButton -> finish()
        }
    }

    private fun postDataToSQL() {
        if(!loginValidation!!.isInputEditTextFilled(usernameEditText, usernameField, getString(R.string.error_message_name))) {
            return
        }
        if(!loginValidation!!.isInputEditTextFilled(emailEditText, emailField, getString(R.string.error_message_email))) {
            return
        }
        if(!loginValidation!!.isInputEditTextEmail(emailEditText, emailField, getString(R.string.error_message_email))) {
            return
        }
        if(!loginValidation!!.isInputEditTextMatches(passwordEditText, passwordConfirmEditText, passwordConfirmField, getString(R.string.error_password_match))) {
            return
            }
        if(!dataBaseHelper!!.checkUser(emailEditText!!.text.toString().trim())) {
            var user = User(name = usernameEditText!!.text.toString().trim(),
            email = emailEditText!!.text.toString().trim(),
            password = passwordEditText!!.text.toString().trim())

            dataBaseHelper!!.addUser(user)


            Toast.makeText(this!!, getString(R.string.success_message), Toast.LENGTH_LONG).show()
            emptyInputEditText()

        } else {
            Toast.makeText(this!!, getString(R.string.error_email_exists), Toast.LENGTH_LONG).show()
        }
    }

    private fun emptyInputEditText() {
        emailEditText!!.text = null
        usernameEditText!!.text = null
        passwordEditText!!.text = null
        passwordConfirmEditText.text = null
    }

}