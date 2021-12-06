package com.sgtst.proyect_cobra

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbtn = findViewById<Button>(R.id.startButton)
        val offerbtn = findViewById<Button>(R.id.offerButton)
        val allbtn = findViewById<Button>(R.id.allButton)
        val accountbtn = findViewById<Button>(R.id.accountButton)

        val accountActivity = Intent(this, LoginActivity::class.java).apply { }
        val allActivity = Intent(this, AllActivity::class.java).apply { }
        val aboutActivity = Intent(this, StartActivity::class.java).apply { }
        val offerActivity = Intent(this, OfferActivity::class.java).apply { }


        startbtn.setOnClickListener {
            Log.i("StartActivity", "Start Button Pressed")
            Toast.makeText(this, "Start Button Pressed. WIP.", Toast.LENGTH_SHORT).show()
            startActivity(aboutActivity)
        }

        offerbtn.setOnClickListener {
            Log.i("StartActivity", "Offer Button Pressed")
            Toast.makeText(this, "Offer Button Pressed. WIP.", Toast.LENGTH_SHORT).show()
            startActivity(offerActivity)
        }

        allbtn.setOnClickListener {
            Log.i("StartActivity", "Global Button Pressed.")
            Toast.makeText(this, "Global Button Pressed. WIP.", Toast.LENGTH_SHORT).show()
            startActivity(allActivity)

        }

        accountbtn.setOnClickListener {
            Log.i("StartActivity", "Account Button Pressed.")
            Toast.makeText(this, "Account Button Pressed. WIP.", Toast.LENGTH_SHORT).show()
            startActivity(accountActivity)
        }
    }

    companion object {
        var logged: Boolean = false
    }
}