package com.bashayer.mystroy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email=intent.getStringExtra("email") //get entered email from the login activity
        val tvemail:TextView = findViewById(R.id.tvEmail) // connect textview
        tvemail?.text=email // assign email to the textview to show in the main activity
    }

}