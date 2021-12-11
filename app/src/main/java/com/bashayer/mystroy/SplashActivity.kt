package com.bashayer.mystroy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //delay the splash screen before move to the login screen
        Handler(Looper.myLooper()!!).postDelayed({
            // finish() to remove the splash activity from memory (destroy) before move to login screen
            finish()
            //move to login screen
            val theintent = Intent(this,LoginActivity::class.java)
            startActivity(theintent)
        },5000 )//5 seconds



    }
}