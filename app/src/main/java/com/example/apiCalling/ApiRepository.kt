package com.example.apiCalling

import retrofit2.Response

class ApiRepository(baseUrl : String, token : String) {
    val retrofit = ApiClient.getApi(baseUrl,token)
    val apiService  = retrofit.create(ApiService::class.java)

    suspend fun getData() : Response<ApiResponse> = apiService.getNew()
}