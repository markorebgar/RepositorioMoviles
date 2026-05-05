package com.example.mshop2.model

import com.example.mshop2.api.LoginRequest
import com.example.mshop2.api.RetrofitApi
import com.example.mshop2.api.TiendaRespuestaToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MiModel {

    lateinit var respuestaToken : TiendaRespuestaToken

    val retrofitApi = RetrofitApi()


    suspend fun recuperarToken(email : String, password : String) : String? = withContext(Dispatchers.IO){
        try{
            val respuesta = retrofitApi.retrofitService.getToken(LoginRequest(email,password))

            if(respuesta.isSuccessful && respuesta.body() != null){
                respuestaToken = TiendaRespuestaToken(respuesta.body()!!.accessToken, respuesta.body()!!.refreshToken)
                respuestaToken.accessToken
            }else{
                null
            }
        }catch (e : Exception){
            e.printStackTrace()
            null
        }

    }

}