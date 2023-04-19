package com.swift.datapasstofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_1, container, false)
        val button : Button = view.findViewById(R.id.fragment2_btn)
        button.setOnClickListener {
            val edittext: EditText = view.findViewById(R.id.enter_text)
            val input = edittext.text.toString()
            val bundle = Bundle()
            bundle.putString("data",input)

            val fragment = Fragment2()
            fragment.arguments = bundle

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, fragment).commit()
                addToBackStack(null)
            }


        }
        return view
    }


}