package com.simple.counter

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simple.counter.model.ModelChat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * 1. RecyclerView.Adapter = FINISHED
 * 2. RecyclerView.ViewHolder
 * 3. LayoutManager
 * 4. Layout/Design that you want to show = FINISHED
 */

class ActivityListItemChat: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_names)

        val serviceChat: ServiceChat = getRetrofit().create(ServiceChat::class.java)
        serviceChat.getChatItems().enqueue(object: Callback<List<ModelChat>>{
            override fun onResponse(
                call: Call<List<ModelChat>>,
                response: Response<List<ModelChat>>
            ) {
                if(response.isSuccessful){
                    var recyclerViewChatItems: RecyclerView = findViewById(R.id.listOfNames)
                    val adapter = AdapterChatItem()
                    recyclerViewChatItems.adapter = adapter
                    recyclerViewChatItems.layoutManager = LinearLayoutManager(this@ActivityListItemChat)
                    var listItems = response.body()
                    adapter.updateList(listItems)
                } else {
                    Log.d("RequestFailed", "Response was not successful!")
                }
            }

            override fun onFailure(call: Call<List<ModelChat>>, t: Throwable) {
                Log.e("RequestFailed", t.stackTraceToString())
            }

        })

    }

    fun getRetrofit(): Retrofit {
        val retrofit : Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://droidr.tech/")
            .build()
        return retrofit
    }

}