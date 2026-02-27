package com.example.colores.viewmodel

import androidx.lifecycle.ViewModel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import com.example.colores.model.Datos
import com.example.colores.model.RecyclerModel
import kotlinx.coroutines.launch

class RecyclerViewModel : ViewModel() {

    var miModelo = RecyclerModel()

    private var _datos = MutableStateFlow<Datos>(Datos("", mutableListOf()))

    public val datos : StateFlow<Datos> get() = _datos

    public fun retornarLista(){
        viewModelScope.launch{
            _datos.value = miModelo.retornarLista()
        }


    }


}