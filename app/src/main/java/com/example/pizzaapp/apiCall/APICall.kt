package com.example.pizzaapp.apiCall

import com.example.pizzaapp.responseData.ResponseDTO
import com.example.pizzaapp.responseData.Size
import retrofit2.Call
import retrofit2.http.GET

interface APICall {

    @GET("pizzas")
   suspend fun getAllCharacters():ResponseDTO
   fun getSize():Size
}

interface ClickListner {
    fun click(positon:Int)
}