package com.example.pizzaapp.repository

import com.example.pizzaapp.apiCall.Network
import com.example.pizzaapp.responseData.ResponseDTO

class Repository {
    suspend fun getAllCharacters(): ResponseDTO {
        return Network.getApiService().getAllCharacters()
    }
}