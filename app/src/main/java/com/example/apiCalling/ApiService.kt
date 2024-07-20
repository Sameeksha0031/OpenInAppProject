package com.example.apiCalling

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v1/dashboardNew")
    suspend fun getNew() : Response<ApiResponse>
}