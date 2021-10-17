package com.example.malubaymlab02
//welcome
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

//        open order form button
            val btnOrderForm = findViewById<Button>(R.id.btnOrderHere)
            val context = btnOrderForm.context
            val iNext = Intent(this,orderForm::class.java)
            btnOrderForm?.setOnClickListener{
                startActivity(iNext)}
    }
}