package com.example.malubayflab01

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class profile : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val goToHome = findViewById<Button>(R.id.btnCancel)
        val context = goToHome.context
        val iHome = Intent(context, MainActivity::class.java)

        goToHome?.setOnClickListener {
            context.startActivity(iHome)
        }
        lateinit var profileShared: SharedPreferences
        lateinit var fn: String
        lateinit var ln: String
        lateinit var address: String
        lateinit var email: String
        lateinit var mobileNum: String

        lateinit var btnCancel: FloatingActionButton
        lateinit var saveProf: Button
        lateinit var showProf: Button

        lateinit var firstName: EditText
        lateinit var lastName: EditText
        lateinit var mobileNumber: EditText
        lateinit var myEmail: EditText

    }
        fun show(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            val builder = AlertDialog.Builder(this)
            builder.setMessage(message)
//            builder.setPositiveButton(R.string.ok_button_title, null)

            val dialog = builder.create()
            dialog.show()
        }

        fun goHome() {
            TODO("Not yet implemented")
        }


        fun clear() {
            finish()
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }

        fun initWidgets() {

            var btnCancel = findViewById<Button>(R.id.btnCancel)
            var save = findViewById<Button>(R.id.btnSave)
            var fn = findViewById<EditText>(R.id.fname)
            var ln = findViewById<EditText>(R.id.lname)
            var address = findViewById<EditText>(R.id.address)
            var email = findViewById<EditText>(R.id.email)
            var mobileNumber = findViewById<EditText>(R.id.mobileNumber)
        }

        fun addListener() {
            var btnCancel = findViewById<Button>(R.id.btnCancel)
            var save = findViewById<Button>(R.id.btnSave)
            btnCancel.setOnClickListener(this)
            save.setOnClickListener(this)
        }

        fun initSharedPref(lastName: String): Nothing? {
            var lastN = lastName
            if (lastN == "") {
                show("Enter Lastname")
            } else {
                var profileShared = getSharedPreferences(lastN, Context.MODE_PRIVATE)
            }
            val profileShared = null
            return profileShared
        }

        fun saveProfile(
            fname: String,
            lname: String,
            address: String,
            email: String,
            mobileNumber: String,
        ) {
           var profileShared: SharedPreferences
            val edit = profileShared.edit()
            edit.putString("fn", fname)
            edit.putString("ln", lname)
            edit.putString("mobileNumber", mobileNumber)
            edit.putString("email", email)


            edit.apply()
            show("Profile Saved")
            clear()
        }


        override fun onClick(view: View?) {
            when (view!!.id) {
                R.id.btnSave -> {
                    var btnCancel = findViewById<Button>(R.id.btnCancel)
                    var save = findViewById<Button>(R.id.btnSave)
                    var fn = findViewById<EditText>(R.id.fname)
                    var ln = findViewById<EditText>(R.id.lname)
                    var address = findViewById<EditText>(R.id.address)
                    var email = findViewById<EditText>(R.id.email)
                    var mobileNumber = findViewById<EditText>(R.id.mobileNumber)

                    if (fn.text.isEmpty() &&
                        ln.text.isEmpty() &&
                        address.text.isEmpty() &&
                        email.text.isEmpty() &&
                        mobileNumber.text.isEmpty()
                    ) {
                        show("Please fill all the fields")
                    } else {
                        //values to be stored
                        var fn = fn.text.toString()
                        var ln = ln.text.toString()
                        var address = address.text.toString()
                        var email = email.text.toString()
                        var mobileNumber = mobileNumber.text.toString()


                        //invoke function to initialize and create SharedPrefs
                        initSharedPref(ln)
                        //invoke function to save to SharedPrefs with args
                        saveProfile(fn, ln, address, email, mobileNumber)
                    }
                }
                R.id.btnCancel -> goHome() //invoke function to navigate to HomeActivity
                else -> show("No Click")
            }
        }

        fun Button.setOnClickListener(profile: profile) {

        }


    }




private fun Button.setOnClickListener(profile: profile) {

}
