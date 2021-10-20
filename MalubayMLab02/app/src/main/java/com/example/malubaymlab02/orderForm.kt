package com.example.malubaymlab02

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class orderForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_form)

        val submitOrder = findViewById<Button>(R.id.btnsubmitOrder)
        val editName = findViewById<EditText>(R.id.editName)
        val editMobilePhone = findViewById<EditText>(R.id.editMobilePhone)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editAddress = findViewById<EditText>(R.id.editAddress)
        val editFood = findViewById<EditText>(R.id.editFood)
        val editBeverage = findViewById<EditText>(R.id.editBeverage)
        var submit: Intent

        submitOrder?.setOnClickListener {
            submit = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(editEmail.text.toString()))
                putExtra(Intent.EXTRA_TEXT, editFood.text.toString())
                putExtra(Intent.EXTRA_TEXT, editBeverage.text.toString())}

               try {
                    startActivity(submit)
                    Toast.makeText(this, "Order Sent", Toast.LENGTH_LONG).show()

                } catch (e: ActivityNotFoundException) {

                    Toast.makeText(this,"Error!!!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }



