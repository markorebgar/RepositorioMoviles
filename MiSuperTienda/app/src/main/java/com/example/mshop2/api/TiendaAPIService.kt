package com.example.mshop2.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface TiendaAPIService {

    @POST("auth/login")
    suspend fun getToken(@Body request: LoginRequest) : Response<TiendaRespuestaToken>
}