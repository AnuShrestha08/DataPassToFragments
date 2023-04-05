package com.example.firstday

import android.content.Context
import android.content.SharedPreferences

class PrefManager (context: Context){
    val PRIVATE_MODE = 0
    private val PREF_NAME = "SharedPreferences" //file name
    private val IS_VALIDATE = "is_validate"

    val pref: SharedPreferences? = context?.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    val editor: SharedPreferences.Editor? = pref?.edit()

    fun setValidate(isValidate: Boolean){
        editor?.putBoolean(IS_VALIDATE, isValidate)
        editor?.commit()
    }

    fun setUsername(username: String?){
        editor?.putString("username", username)
        editor?.commit()
    }

    fun isValidate():Boolean?{
        return pref?.getBoolean(IS_VALIDATE, false)
    }

    fun getUsername() : String?{
        return pref?.getString("username", "")

    }

    fun removeData(){
        editor?.clear()
        editor?.commit()
    }
}