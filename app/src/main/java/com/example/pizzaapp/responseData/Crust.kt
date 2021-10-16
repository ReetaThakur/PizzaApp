package com.example.pizzaapp.responseData

data class Crust(
    val defaultSize: Int,
    val id: Int,
    val name: String,
    val sizes: List<Size>
)