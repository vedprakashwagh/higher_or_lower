package com.simple.counter

import com.simple.counter.model.ModelChat
import retrofit2.Call
import retrofit2.http.GET

interface ServiceChat {
    @GET("android/data.json")
    fun getChatItems() : Call<List<ModelChat>>
}