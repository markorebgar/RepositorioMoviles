package com.example.composeperros.model

import com.example.composeperros.api.DogRespuestaImages
import com.example.composeperros.api.DogRespuestaRazasSubrazas
import com.example.composeperros.api.RetrofitApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecyclerModel {

    lateinit var razasYSubrazas : DogRespuestaRazasSubrazas

    lateinit var images : DogRespuestaImages
    val retrofitApi = RetrofitApi()
    var misDatos: Datos = Datos("error", null, null)

    suspend fun recuperarRazasPerros() : Datos = withContext(Dispatchers.IO){
        val respuesta = retrofitApi.retrofitService.getRazasPerros()
        if(respuesta.isSuccessful){
            razasYSubrazas = DogRespuestaRazasSubrazas(respuesta.body()!!.message, respuesta.body()!!.status)
            misDatos.status = razasYSubrazas.status
            misDatos.razasYSubrazas = razasYSubrazas.message
            misDatos!!
        }else{
            misDatos!!
        }
    }

    suspend fun recuperarFotosDeRaza(raza : String) : Datos = withContext(Dispatchers.IO){
        val respuesta = retrofitApi.retrofitService.getImagesByBreed(raza)

        if(respuesta.isSuccessful){
            images = DogRespuestaImages(respuesta.body()!!.status, respuesta.body()!!.message)

            misDatos.fotos = images.message
            misDatos!!
        }else{
            misDatos.status = "error";
            misDatos!!

        }

    }

    suspend fun recuperarFotosDeSubraza(raza : String, subRaza : String) : Datos = withContext(Dispatchers.IO){
        val respuesta = retrofitApi.retrofitService.getImagesBySubBreed(raza, subRaza)

        if(respuesta.isSuccessful){
            images = DogRespuestaImages(respuesta.body()!!.status, respuesta.body()!!.message)

            misDatos.fotos = images.message
            misDatos!!
        }else{
            misDatos.status = "error";
            misDatos!!

        }

    }


}