package com.example.apiCalling

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(val token : String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val reportUsageRequest = chain.request().newBuilder()
            .addHeader("Authorization","Bearer $token")
            .build()
        return chain.proceed(reportUsageRequest)
    }
}