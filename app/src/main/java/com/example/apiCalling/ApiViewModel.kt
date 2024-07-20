package com.example.apiCalling

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel(val repository: ApiRepository) : ViewModel() {
    private val _data = MutableLiveData<Response<ApiResponse>>()
    val data : LiveData<Response<ApiResponse>> get() = _data

    fun getData() {
        viewModelScope.launch {
            try {
                val response = repository.getData()
                _data.postValue(response)
            } catch (e : Exception){

            }
        }
    }
}