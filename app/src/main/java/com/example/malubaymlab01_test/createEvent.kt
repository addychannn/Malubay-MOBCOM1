package com.example.malubaymlab01_test

import android.annotation.SuppressLint
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

        val btnCreate = findViewById<Button>(R.id.btnCreate)

        btnCreate.setOnClickListener(this)

        btnCreate.visibility = ViewGroup.VISIBLE

        val nAct = findViewById<Button>(R.id.btnBack)
        val context = nAct.context
        val back = Intent(context, MainActivity::class.java)

        nAct?.setOnClickListener {
            context.startActivity(back)
        }
        val startingTime =
            findViewById<EditText>(R.id.startingTime)
        startingTime?.setOnClickListener {
            onStartingTimeClick()
        }
        val endTime =
            findViewById<EditText>(R.id.endTime)
        endTime?.setOnClickListener {
            onEndTimeClick()
        }
        val date =
            findViewById<EditText>(R.id.startDate)
        date?.setOnClickListener {
            onDateClick()
        }

    }

    override fun onClick(view: View?) {
        val title = this.findViewById<EditText>(R.id.title)
        val place = findViewById<EditText>(R.id.eventPlace)
        val description = findViewById<EditText>(R.id.eventDesc)
        val guests = findViewById<EditText>(R.id.addGuests)
        val startingTime =
            findViewById<EditText>(R.id.startingTime)
        val endTime =
            findViewById<EditText>(R.id.endTime)


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
        val intent = Intent(Intent.ACTION_INSERT).apply {//creating a new Calendar event
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

    private fun onStartingTimeClick() {
        val textView = findViewById<TextView>(R.id.startingTime)
        val timePicker = findViewById<TimePicker>(R.id.eventTpcker)
        val datePicker = findViewById<DatePicker>(R.id.evDate)
        timePicker.visibility = ViewGroup.VISIBLE // opens timePicker
        datePicker.visibility =
            ViewGroup.INVISIBLE //hides datePicker
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hr = hour
            val ampm: String

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
                val msg = "Starting Time is: $finhour : $min $ampm"
                textView.text = msg
                textView.visibility = ViewGroup.VISIBLE
            }
        }

    }

    private fun onEndTimeClick() {
        val textView = findViewById<TextView>(R.id.endTime)
        val timePicker = findViewById<TimePicker>(R.id.eventTpcker)
        val datePicker = findViewById<DatePicker>(R.id.evDate)
        timePicker.visibility = ViewGroup.VISIBLE // opens timePicker
        datePicker.visibility =
            ViewGroup.INVISIBLE //hides datePicker
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            var hr = hour
            val ampm: String

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
                val msg = "Ending Time is: $finhour : $min $ampm"
                textView.text = msg
                textView.visibility = ViewGroup.VISIBLE
            }
        }

    }

//    @SuppressLint("WrongViewCast")

    private fun onDateClick() {
        val textView = findViewById<EditText>(R.id.startDate)
        val timePicker = findViewById<TimePicker>(R.id.eventTpcker)
        val datePicker = findViewById<DatePicker>(R.id.evDate)
        timePicker.visibility = ViewGroup.INVISIBLE // opens timePicker
        datePicker.visibility = ViewGroup.VISIBLE //hides datePicker
    }
}

