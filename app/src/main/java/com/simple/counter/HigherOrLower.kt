package com.simple.counter

import android.app.Activity
import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

/**
 * Game - Higher or Lower
 * Rules -
 * 1. Computer chooses a number at random between 0 - 100
 * 2. Take input from user of the guess
 * 3. Computer will tell whether the number was lower or higher
 * 4. User will take next guess depending on computer's output
 * 5. Keep doing it until right number is guessed
 */
class HigherOrLower: AppCompatActivity() {

    var randomNumber: Int = Random.nextInt(0, 101)
    var numberOfTries: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_or_lower)

        val userInput: EditText = findViewById(R.id.userInput)
        val buttonUserGuess: Button = findViewById(R.id.buttonUserGuess)
        val textviewRandomNumber: TextView = findViewById(R.id.textviewRandomNumber)

        textviewRandomNumber.text = "Random number chosen by computer is: "+randomNumber.toString()

        buttonUserGuess.setOnClickListener {

            val userGuess : Int = userInput.text.toString().toInt()
            numberOfTries += 1

            when {
                userGuess > randomNumber -> {
                    Toast.makeText(this@HigherOrLower, "Random number is lower!", Toast.LENGTH_LONG).show()
                }

                userGuess < randomNumber -> {
                    Toast.makeText(this@HigherOrLower, "Random number is higher!", Toast.LENGTH_LONG).show()
                }

                else -> {
                    Toast.makeText(this@HigherOrLower, "Success, you won after ${numberOfTries} tries!", Toast.LENGTH_LONG).show()
                    randomNumber = Random.nextInt(0, 101)
                    textviewRandomNumber.text = "Random number chosen by computer is: "+randomNumber.toString()

                    numberOfTries = 0
                }

            }

        }

    }

}