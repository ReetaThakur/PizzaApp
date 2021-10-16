package com.example.pizzaapp.apiCall

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    fun getRetrofit()=Retrofit.Builder().baseUrl(" https://android.free.beeceptor.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getApiService()= getRetrofit().create(APICall::class.java)
}