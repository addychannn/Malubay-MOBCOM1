package com.example.malubayflab01

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToProfile=findViewById<Button>(R.id.btnProfile)
        val context=goToProfile.context
        val iProfile= Intent(context,profile::class.java)

        goToProfile?.setOnClickListener{
            context.startActivity(iProfile)
        }
    }
}