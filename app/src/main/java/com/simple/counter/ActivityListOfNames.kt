package com.simple.counter

import android.app.Activity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * What do we need for androidx.recyclerview.widget.RecyclerView?
 * 1. RecyclerView.Adapter
 * 2. RecyclerView.ViewHolder
 * 3. LayoutManager - LinearLayoutManager, GridLayoutManager, StaggeredGridLayoutManager
 */

class ActivityListOfNames: Activity() {

    var names = arrayOf("Vedprakash", "Gayatri", "Vaishnavi", "Shlok", "Darshan", "Atharv")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_names)

        val recyclerView: RecyclerView = findViewById(R.id.listOfNames)
        recyclerView.adapter = AdapterNames(names)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}