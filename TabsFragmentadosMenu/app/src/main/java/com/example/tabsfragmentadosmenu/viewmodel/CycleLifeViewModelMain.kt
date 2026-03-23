package com.example.tabsfragmentadosmenu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tabsfragmentadosmenu.model.CycleLifeModelMain
import com.example.tabsfragmentadosmenu.model.DatosMain
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class CycleLifeViewModelMain : ViewModel(){

    val cicloVidaModel = CycleLifeModelMain()
    private var _datos = MutableLiveData<DatosMain>(DatosMain("",0, 0, "Elije número"));

    val datos: LiveData<DatosMain> get() = _datos


    fun retornarRandom(){

        viewModelScope.launch {
            _datos.value = cicloVidaModel.generarRandom()
        }

    }

    fun guardarTab(tabSeleccionado : Int){

        viewModelScope.launch {
            _datos.value = cicloVidaModel.guardarTab(tabSeleccionado)
        }
    }
    fun guardarTitulo(titulo : String){

        viewModelScope.launch {
            _datos.value =  cicloVidaModel.guardarTitulo(titulo)
        }
    }
    fun retornarTitulo() : String{
            return _datos.value.titulo
    }
    fun retornarPosicion() : Int{
        return _datos.value.tabSeleccionado
    }
}