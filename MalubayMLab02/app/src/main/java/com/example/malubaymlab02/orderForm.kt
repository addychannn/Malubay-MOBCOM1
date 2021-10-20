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
        val subject = "Your Orders From Addy's Cafe"
        var submit: Intent

        submitOrder?.setOnClickListener {
            val name = editName.text.toString()
            val mobilePhone = editMobilePhone.text.toString()
            val address = editAddress.text.toString()
            val email = editEmail.text.toString()
            val food = editFood.text.toString()
            val beverage = editBeverage.text.toString()
            val orderMessage:String = "Name: ".plus(name).plus("\n").
                                plus("Contact No: ").plus(mobilePhone).plus("\n").
                                plus("Address: ").plus(address).plus("\n").
                                plus("Email: ").plus(email).plus("\n").
                                plus("Food: ").plus(food).plus("\n").
                                plus("Beverage: ").plus(beverage)

            val intent = Intent(this, confirmOrder::class.java)
            intent.putExtra("Recipient",editEmail.text.toString())
            intent.putExtra("Subject",subject)
            intent.putExtra("Message",orderMessage)
            startActivity(intent)

            submit = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(editEmail.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, orderMessage)}

               try {
                    startActivity(submit)
                    Toast.makeText(this, "Order Sent", Toast.LENGTH_LONG).show()

                } catch (e: ActivityNotFoundException) {

                    Toast.makeText(this,"Error!!!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }



