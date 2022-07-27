package com.simple.counter

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ActivitySimpleCounter: AppCompatActivity() {

    var currentCounterNumber: Int = 0

    val INCREMENTED_NUMBER = "INCREMENTED_NUMBER"
    val SHARED_PREFERENCE_FILE = "COUNTER"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_counter)
        currentCounterNumber = getCounterNumber()

        var textViewCounterNumber: TextView = findViewById(R.id.counterNumber)
        textViewCounterNumber.text = currentCounterNumber.toString()
        var buttonIncrement: Button = findViewById(R.id.buttonIncrement)
        buttonIncrement.setOnClickListener {
            currentCounterNumber += 1
            saveCounterNumber(currentCounterNumber)
            textViewCounterNumber.text = currentCounterNumber.toString()
        }
    }

    fun saveCounterNumber(number: Int) {
        val sharedPreference = getSharedPreferences(SHARED_PREFERENCE_FILE, MODE_PRIVATE)
        sharedPreference.edit().putInt(INCREMENTED_NUMBER, number).apply()
    }

    private fun getCounterNumber() : Int {
        val sharedPreference = getSharedPreferences(SHARED_PREFERENCE_FILE, MODE_PRIVATE)
        return sharedPreference.getInt(INCREMENTED_NUMBER, 0)
    }


}