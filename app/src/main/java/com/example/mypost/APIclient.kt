package com.example.mypost

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIclient {
    var retrofit= Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildAPIclient(apiInterface:Class<T>):T{
        return  retrofit.create(apiInterface)
    }
}