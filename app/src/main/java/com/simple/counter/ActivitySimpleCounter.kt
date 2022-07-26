package com.simple.counter

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivitySimpleCounter: AppCompatActivity() {

    var currentCounterNumber: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_counter)
        var textViewCounterNumber: TextView = findViewById(R.id.counterNumber)
        var buttonIncrement: Button = findViewById(R.id.buttonIncrement)
        buttonIncrement.setOnClickListener {
            currentCounterNumber += 1
            textViewCounterNumber.text = currentCounterNumber.toString()
        }
    }

}