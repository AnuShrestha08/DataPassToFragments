package com.example.firstday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ValidateScreen : AppCompatActivity() {
    private lateinit var prefManager: PrefManager
    private lateinit var usernames : String
    private lateinit var validateTitle : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_screen)

        init()
        checkValidate()
        setupUI()
    }

    private fun init(){
        prefManager = PrefManager(this)
        usernames = prefManager.getUsername().toString()
        validateTitle = findViewById(R.id.validateTitle)
    }

    private fun checkValidate(){
        if(prefManager.isValidate() == false){
            val intent= Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun setupUI(){
        validateTitle.text = "Hello $usernames"

    }

    fun clickSeeU(view: View){
        prefManager.removeData()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}