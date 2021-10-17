package com.example.intentsproject

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
        //Explicit Intent (Open Activity)
        //Bind UI elements to variables
        val nextAct=findViewById<Button>(R.id.btnNext)
        val context = nextAct.context
        val iNext= Intent(this, IntentsActivity2::class.java)
        //add event listener on btnNext
        nextAct?.setOnClickListener{
            startActivity(iNext)
        }
        //1. Open Url
        val strUrl="https://www.youtube.com/c/TraversyMedia"
        val openBrowser = findViewById<Button>(R.id.btnWeb)
        val iBrowser =Intent(Intent.ACTION_VIEW, Uri.parse(strUrl))
        openBrowser?.setOnClickListener{
            startActivity(iBrowser)
        }
        //2. Open Dialer
        val openDialer = findViewById<Button>(R.id.btnDialer)
        val iDialer = Intent(Intent.ACTION_DIAL)
        openDialer?.setOnClickListener{
            startActivity(iDialer)
        }

        //3. Send Message
        val sendMsg=findViewById<Button>(R.id.btnEmail)
        val txtMsg = "Hello there."
        val errMsg= "No Message Found."
        val iSend=Intent().apply {
            action=Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,txtMsg)
            type="text/plain"
        }
        sendMsg?.setOnClickListener{
            try {
                startActivity(iSend)
            }catch (e:ActivityNotFoundException){
                Toast.makeText(this@MainActivity,errMsg,Toast.LENGTH_LONG).show()
            }
        }
        //4. Toast
        val msg="This is a toast message"
        val toastMsg=findViewById<Button>(R.id.btnToast)
        toastMsg?.setOnClickListener{
            Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
        }
    }
}