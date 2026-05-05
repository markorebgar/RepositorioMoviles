package com.example.mshop2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi {
    val retrofitBase = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8000/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService = retrofitBase.create(TiendaAPIService::class.java)
}