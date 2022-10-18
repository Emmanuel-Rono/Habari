package com.example.habari.api

import com.example.habari.util.constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object
    {
        //bylazy can only be instantiated once

     private val retrofit by lazy {
             val logging=HttpLoggingInterceptor()
         logging.setLevel(HttpLoggingInterceptor.Level.BODY)
         val client=OkHttpClient.Builder()
             .addInterceptor(logging)
             .build()
         Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(  GsonConverterFactory.create())
             .client(client)
             .build()
     }
        val api by lazy {
            retrofit.create((NewsApi::class.java))
        }
    }

}