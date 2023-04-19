package com.swift.datapasstofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val textview : TextView = view.findViewById(R.id.text_shown)
        val args = this.arguments
        val inputData = args?.getString("data")
        textview.text = inputData.toString()

        return view
    }


}