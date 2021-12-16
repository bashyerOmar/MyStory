package com.bashayer.mystroy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private var tvEmail:TextView?=null
    private var toolbar:Toolbar?=null
    private var drawer:DrawerLayout?=null
    private var navigationView:NavigationView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email=intent.getStringExtra("email") //get entered email from the login activity
        connectviews()
       // tvEmail?.text=email // assign email to the textview to show in the main activity
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
        setEmailAtTheNavHeader(email.toString())
        interactionWithDrawer()
    }

    private fun setEmailAtTheNavHeader( Email:String){
      val headerView =navigationView?.getHeaderView(0)
        val textViewEmail=headerView?.findViewById<TextView>(R.id.tvemail)
        textViewEmail?.text=Email
    }
    private fun connectviews(){
        tvEmail= findViewById(R.id.tvEmail) // connect textview
        drawer=findViewById(R.id.drawer)
        toolbar=findViewById(R.id.toolbar)
        navigationView=findViewById(R.id.nav)

    }
    private fun setupDrawer(){

     val toggle=ActionBarDrawerToggle(this,drawer,R.string.open , R.string.close)
     drawer?.addDrawerListener(toggle)
        toggle.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home ->{  //if hamburger icon clicked the drawer will open from left (start)
                drawer?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }

    }
    private fun interactionWithDrawer(){
       navigationView?.setNavigationItemSelectedListener {
           when (it.itemId){
               R.id.home -> {
                   drawer?.closeDrawer(GravityCompat.START)
                   true
               }
               R.id.logout -> {
                   finish()
                  val intent = Intent(this,LoginActivity::class.java)
                   startActivity(intent)
                   true
               }
               else -> true

           }
       }
    }
}