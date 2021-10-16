package com.example.pizzaapp.responseData

data class ResponseDTO(
    val crusts: List<Crust>,
    val defaultCrust: Int,
    val description: String,
    val isVeg: Boolean,
    val name: String
)