package com.example.apitest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val baseUrl="https://catfact.ninja/"

    fun getInstance() : Retrofit =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    fun getServices():ApiServices = getInstance().create(ApiServices::class.java)



}