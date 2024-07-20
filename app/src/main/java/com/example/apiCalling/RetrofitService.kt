package com.example.apiCalling

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun retrofitService(token : String) : ApiService {
    val authInterceptor = AuthInterceptor(token)

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.inopenapp.com/api")
        .client(OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}