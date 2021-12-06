package com.sgtst.proyect_cobra

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.NestedScrollView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private val activity = this@LoginActivity

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var emailTextField: TextView
    private lateinit var passwordTextField: TextView

    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    private lateinit var loginValidation: LoginValidation
    private lateinit var dataBaseHelper: DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        supportActionBar!!.hide()
        initViews()
        initListeners()
        initObjects()
    }

    private fun initViews() {
        emailTextField = findViewById<View>(R.id.emailTextField) as TextView
        passwordTextField = findViewById<View>(R.id.passwordTextField) as TextView

        emailEditText = findViewById<View>(R.id.emailEditText) as EditText
        passwordEditText = findViewById<View>(R.id.passwordEditText) as EditText

        loginButton = findViewById<View>(R.id.loginButton) as Button
        registerButton = findViewById<View>(R.id.registerButton) as Button
    }

    private fun initListeners() {
        loginButton!!.setOnClickListener(this)
        registerButton!!.setOnClickListener(this)
    }

    private fun initObjects(){

        dataBaseHelper = DataBaseHelper(activity)
        loginValidation = LoginValidation(activity)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.loginButton -> verifyFromSQLite()
            R.id.registerButton -> {
                val registerActivity = Intent(applicationContext, RegisterActivity::class.java)
                startActivity(registerActivity)
            }
        }
    }
    private fun verifyFromSQLite(){
        if(!loginValidation!!.isInputEditTextFilled(emailEditText!!, emailTextField!!, getString(R.string.error_message_email))) {
            return
        }
        if(!loginValidation!!.isInputEditTextEmail(emailEditText!!, emailTextField!!, getString(R.string.error_message_email))) {
            return
        }
        if(!loginValidation!!.isInputEditTextFilled(passwordEditText!!, passwordTextField!!, getString(R.string.error_message_password))){
            return
        }

        if (dataBaseHelper!!.checkUser(emailEditText!!.text.toString().trim { it <= ' '}, passwordEditText!!.text.toString().trim { it <= ' '})){
            val passIntent = Intent(activity, PassActivity::class.java)
            passIntent.putExtra("EMAIL", emailEditText!!.text.toString().trim { it <= ' '})
            emptyImputEditText()
            startActivity(passIntent)
        } else {
            Toast.makeText(this, getString(R.string.error_valid_email_password), Toast.LENGTH_SHORT).show()
        }
    }

    private fun emptyImputEditText() {
        emailEditText!!.text = null
        passwordEditText!!.text = null
    }
}