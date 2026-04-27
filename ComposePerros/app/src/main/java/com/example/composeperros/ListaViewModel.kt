package com.example.composeperros

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeperros.model.Datos
import com.example.composeperros.model.RecyclerModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListaViewModel : ViewModel() {

    val myState : RecyclerModel = RecyclerModel()
    private val _misDatos = MutableStateFlow<Datos>(Datos("",null,null))

    val misDatos : StateFlow<Datos> get() = _misDatos

    fun recuperarRazasYSubrazas(){
        viewModelScope.launch {
            _misDatos.value = myState.recuperarRazasPerros()
        }
    }

    init {
        recuperarRazasYSubrazas()
    }

    fun recuperarFotosDeRaza(raza: String){
        viewModelScope.launch {
            _misDatos.value = myState.recuperarFotosDeRaza(raza)
        }
    }

    fun recuperarFotosDeSubraza(raza: String, subraza: String){
        viewModelScope.launch {
            _misDatos.value = myState.recuperarFotosDeSubraza(raza, subraza)
        }
    }


}