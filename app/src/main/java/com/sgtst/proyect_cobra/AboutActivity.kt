package com.sgtst.proyect_cobra

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = getString(R.string.about_us_text)

        val callButton = findViewById<View>(R.id.callButton) as ImageButton
        val mapButton = findViewById<View>(R.id.mapButton) as ImageButton
        val number = getString(R.string.test_phone)
        val mapactivity = Intent(this, MapActivity::class.java).apply {  }
        val call = Intent(Intent.ACTION_CALL)
        call.data = Uri.parse("tel:$number")

        callButton.setOnClickListener(){
            startActivity(call)
        }

        mapButton.setOnClickListener(){
            startActivity(mapactivity)
        }
    }
}