package com.example.mshop.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {
    val retrofitBase = Retrofit.Builder()
        .baseUrl("http://localhost:8000/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService = retrofitBase.create(TiendaAPIService::class.java)
}