package com.example.mshop.api

import retrofit2.Response
import retrofit2.http.POST

interface TiendaAPIService {

    @POST("auth/login")
    suspend fun getToken(email : String, password : String) : Response<TiendaRespuestaToken>
}