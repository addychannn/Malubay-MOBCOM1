package com.example.malubaymlab02

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class confirmOrder : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_order)

        val sr =  findViewById<TextView>(R.id.editEmail)
        val ss = findViewById<TextView>(R.id.subject)
        val sm = findViewById<TextView>(R.id.orderMessage)

        val recipient=intent.getStringExtra("Recipient\n")
        val subject=intent.getStringExtra("Subject\n")
        val message=intent.getStringExtra("Message\n")

        sr.text= recipient
        ss.text= subject
        sm.text= message

    }
}