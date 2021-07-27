package com.example.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {
    @GET("posts")
    fun getPost():Call<List<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id")postId:Int):Call<Post>
}