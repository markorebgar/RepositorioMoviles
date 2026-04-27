package com.example.composeperros.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsAPIService {
    @GET("breeds/list/all")
    suspend fun getRazasPerros() : Response<DogRespuestaRazasSubrazas>

    @GET("breed/{breed}/images")
    suspend fun getImagesByBreed(@Path("breed") raza: String) : Response<DogRespuestaImages>

    @GET("breed/{breed}/{subbreed}/images")
    suspend fun getImagesBySubBreed(@Path("breed") raza: String, @Path("subbreed") subraza: String) : Response<DogRespuestaImages>




}