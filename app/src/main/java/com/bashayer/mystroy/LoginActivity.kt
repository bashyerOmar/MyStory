package com.bashayer.mystroy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private var etusername:EditText?=null
    private var etpassword:EditText?=null
    private var loginbtn:Button?=null
    private var chkbox:CheckBox?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

         conncet_views()
         login()


    }

    private fun conncet_views(){

        etusername =findViewById(R.id.etusername)
        etpassword=findViewById(R.id.etupass)
        loginbtn=findViewById(R.id.btn)
        chkbox=findViewById(R.id.chkbox)

    }

    private fun login(){

        val userArray:ArrayList<User> = ArrayList()
        userArray.add(User("besho.om.alghamdi@gmail.com","1234567"))
        userArray.add(User("besh@hotmail.com","123"))
        userArray.add(User("1234@gmail.com","1234"))


        loginbtn?.setOnClickListener{
            checkFildes() // check if user enter username and password
            val EntireUser = User (etusername?.text.toString() , etpassword?.text.toString())
            var flag:Boolean=false
            for (user in userArray) {
                if (user.Email == EntireUser.Email && user.password == EntireUser.password) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show()
                    flag = true
                    break
                }
            } //end loop

                if (flag == false ){ //login failed
                    Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show()
                }else{
                    //move to the main activity after login screen
                    val intent= Intent(this,MainActivity::class.java)
                    intent.putExtra("email",EntireUser.Email)
                    startActivity(intent)
                }



        }

    }

    private fun  checkFildes() {
        if (etusername?.text.toString().isEmpty() == true)
          etusername?.setError("please Enter your Email")

        if (etpassword?.text.toString().isEmpty() == true)
            etpassword?.setError("please enter your password")
    }


}