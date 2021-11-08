package com.example.malubaymlab01_test

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*

class createEvent : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)

        val nAct = findViewById<Button>(R.id.btnBack)
        val context = nAct.context
        val back = Intent(context, MainActivity::class.java)

        nAct?.setOnClickListener {
            context.startActivity(back)
        }
    }

    override fun onClick(view: View?) {
        val title = this.findViewById<EditText>(R.id.title)
        val place = findViewById<EditText>(R.id.eventPlace)
        val description = findViewById<EditText>(R.id.eventDesc)
        val guests = findViewById<EditText>(R.id.addGuests)
        var startingTime =
            findViewById<EditText>(R.id.startingTime) //this need to be converted into timeInMills
        val endTime =
            findViewById<EditText>(R.id.endTime)   //this need to be converted into timeInMills

        //temporary constant begin time
        val begin: Long = Calendar.getInstance().run {
            set(2021, 11, 5, 17, 30)
            timeInMillis
        }
        //temporary constant end time
        val end: Long = Calendar.getInstance().run {
            set(2021, 11, 5, 20, 30)
            timeInMillis
        }

        when (view!!.id) {
            R.id.btnCreate -> {
                if (title.text.toString().isEmpty() &&
                    place.text.toString().isEmpty() &&
                    startingTime.text.toString().isEmpty() &&
                    endTime.text.toString().isEmpty() &&
                    description.text.toString().isEmpty() &&
                    guests.text.toString().isEmpty()
                ) {
                    Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                } else {
                    saveEvent(
                        title.text.toString(),
                        place.text.toString(),
                        begin,
                        end,
                        description.text.toString(),
                        guests.text.toString()
                    )
                }
            }//end for fabSave button

        }//end when
    }//end of function

    private fun saveEvent(
        title: String,
        location: String,
        begin: Long,
        end: Long,
        description: String,
        recipients: String
    ) {
        val intent = Intent(Intent.ACTION_INSERT).apply {//Used for creating a new Calendar event
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, location)
            putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end)
            putExtra(CalendarContract.Events.DESCRIPTION, description) // Description
            putExtra(Intent.EXTRA_EMAIL, arrayOf(recipients))
        }
        try {
            startActivity(intent)
            Toast.makeText(applicationContext, "$title Saved", Toast.LENGTH_SHORT).show()
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(applicationContext, "Content error", Toast.LENGTH_LONG).show()
        }
    }

    private fun onTimeClick() {
        val textView = this.findViewById<TextView>(R.id.eventTime)
        val timePicker = findViewById<TimePicker>(R.id.eventTime)
        val datePicker = findViewById<DatePicker>(R.id.evDate)
        timePicker.visibility = ViewGroup.VISIBLE //shows or opens timePicker
        datePicker.visibility =
            ViewGroup.INVISIBLE //hides datePicker (or create a function to toggle visibility)
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hr = hour
            val ampm: String
            // determines if input time is AM or PM
            when {
                hour == 0 -> {
                    hr += 12
                    ampm = "AM"
                }
                hour == 12 -> ampm = "PM"
                hour > 12 -> {
                    hr -= 12
                    ampm = "PM"
                }
                else -> ampm = "AM"
            }
            if (textView != null) {
                val finhour = if (hour < 10) "0$hour" else hour
                val min = if (minute < 10) "0$minute" else minute
                // display format of time
                val msg = "Time is: $finhour : $min $ampm"
                textView.text = msg
                textView.visibility = ViewGroup.VISIBLE
            }
        }
    }
}