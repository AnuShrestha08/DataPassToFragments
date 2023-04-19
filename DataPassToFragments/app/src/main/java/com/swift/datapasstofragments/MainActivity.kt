package com.swift.datapasstofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment1 = Fragment1()
        val btn_fragment = findViewById<Button>(R.id.fragment1_btn)
        btn_fragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, firstFragment1)
                addToBackStack(null)
                commit()
            }
        }
    }
}