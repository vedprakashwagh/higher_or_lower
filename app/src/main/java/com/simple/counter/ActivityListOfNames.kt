package com.simple.counter

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityListOfNames: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_names)
    }
}