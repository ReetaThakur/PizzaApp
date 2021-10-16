package com.example.pizzaapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pizzaapp.repository.Repository
import com.example.pizzaapp.responseData.ResponseDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PizzaViewModelClass: ViewModel() {
    private val mainRespositry = Repository()
    private val mutableLiveData = MutableLiveData<ResponseDTO>()
    val liveData: LiveData<ResponseDTO> = mutableLiveData

    fun callApi() {
        CoroutineScope(Default).async {
            val response: ResponseDTO = mainRespositry.getAllCharacters()
            mutableLiveData.postValue(response)

        }
    }
}