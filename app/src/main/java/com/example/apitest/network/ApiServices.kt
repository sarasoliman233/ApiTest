package com.example.apitest.network

import CatFactResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("facts")

    fun fetchCatFacts():Call<CatFactResponse>




}