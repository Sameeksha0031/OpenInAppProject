package com.example.apiCalling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: ApiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ApiViewModel::class.java)){
            return ApiViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}