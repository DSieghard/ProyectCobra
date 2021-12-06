package com.sgtst.proyect_cobra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        title = "Register Form"
    }
}