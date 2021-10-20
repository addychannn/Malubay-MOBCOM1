package com.example.naviproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //bind your navi components
        val drawerLayout:DrawerLayout=findViewById(R.id.myDrawerLayout)
        val navView:NavigationView=findViewById(R.id.nav_view)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.id_home->makeText(applicationContext,"Take me home.", Toast.LENGTH_SHORT).show()
                R.id.id_login->makeText(applicationContext,"Login.", Toast.LENGTH_SHORT).show()
                R.id.id_logout->makeText(applicationContext,"Logout.", Toast.LENGTH_SHORT).show()
                else-> makeText(applicationContext, "End",Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}