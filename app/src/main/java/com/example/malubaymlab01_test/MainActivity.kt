package com.example.malubaymlab01_test

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

        val nAct=findViewById<Button>(R.id.mainCreate)
        val context=nAct.context
        val goTocreateEvent=Intent(context,createEvent::class.java)

        nAct?.setOnClickListener{
            context.startActivity(goTocreateEvent)
        }
    }
    }


