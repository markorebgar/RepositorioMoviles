package com.example.mshop2.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MiViewModel : ViewModel(){
    val myState : MiModel = MiModel()

    private val _accessToken = MutableStateFlow<String>("")

    val accessToken : StateFlow<String> get() = _accessToken

    fun recuperarToken(email : String, password : String){
        viewModelScope.launch {
            var respuesta = myState.recuperarToken(email, password)
            if (respuesta != null) {
                _accessToken.value = respuesta
            }else{
                _accessToken.value = "error"
            }

        }
    }

    fun setAccessToken(token : String?){
        if(token != null){
            _accessToken.value = token
        }
    }


}