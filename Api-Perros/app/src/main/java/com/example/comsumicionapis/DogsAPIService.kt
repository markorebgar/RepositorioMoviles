package com.example.comsumicionapis

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsAPIService {

    @GET("{raza}/images")
    suspend fun getFotosPerros( @Path("raza") raza: String) : Response<DogRespuesta>
}
