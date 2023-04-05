package com.example.firstday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var prefManager: PrefManager
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var validate : Button

    private lateinit var usernames : String
    private lateinit var passwords : String


    //Data Validation
    private var validUsername = "anushrestha"
    private var validPassword = "firstTask123"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        checkValidate()

//        username = findViewById(R.id.username)
//
//        password=findViewById(R.id.password)
//        validate = findViewById(R.id.validate)
//
//
//                validate.setOnClickListener {
//                    val usernameBtn = username.text.toString().trim()
//                    val passwordBtn = password.text.toString().trim()
//
//
//                    if (usernameBtn.isEmpty()){
//                        username.error = "Enter correct username"
//                        return@setOnClickListener
//                    }else if(passwordBtn.isEmpty()){
//                        password.error = "Enter correct password"
//                        return@setOnClickListener
//                    }else{
//                        Toast.makeText(this,"ValidationCompleted",Toast.LENGTH_SHORT).show()
//                    }
//
//
//                }

    }
    private fun init(){
        prefManager = PrefManager(this)
        username = findViewById(R.id.username)
        password=findViewById(R.id.password)
        validate = findViewById(R.id.validate)
    }

    private fun checkValidate(){
        if (prefManager.isValidate()!!){
            val intent = Intent(this, ValidateScreen::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun clickValidate(view : View){
        usernames = username.text.toString().trim()
        passwords = password.text.toString().trim()
        if (usernames.isEmpty() || usernames== " "){
            username.error = "Please! enter username"
            username.requestFocus()
        }else if (passwords.isEmpty() || passwords== " "){
            password.error = "Please! enter password"
            password.requestFocus()
        }else if (usernames!= validUsername){
            username.error = "Enter correct username"
            username.requestFocus()
        }else if (passwords!= validPassword){
            password.error = "Enter correct password"
            password.requestFocus()
        }else{
            prefManager.setValidate(true)
            prefManager.setUsername(usernames)
            val intent= Intent(this, ValidateScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}