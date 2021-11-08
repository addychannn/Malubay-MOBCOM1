package com.example.malubaymlab01_test

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class createEvent : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        val nAct=findViewById<Button>(R.id.btnBack)
        val context=nAct.context
        val back=Intent(context,MainActivity::class.java)

        nAct?.setOnClickListener{
            context.startActivity(back)
        }
    }

    override fun onClick(view: View?){

    }
}