package com.example.comsumicionapis.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comsumicionapis.DogRespuesta
import com.example.comsumicionapis.model.Datos
import com.example.comsumicionapis.model.RecyclerModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecyclerViewModel : ViewModel() {
    val myEstado = RecyclerModel()

    private val _datos = MutableLiveData<Datos>(Datos(null.toString(),null,null, ArrayList()))

    val datos: LiveData<Datos> get() = _datos

    fun devuelveFotos(raza: String){

        viewModelScope.launch {
            _datos.value = myEstado.recuperaFotos(raza)
        }

    }
    fun scrollFotos(){
        viewModelScope.launch {
            _datos.value = myEstado.scrollFotos()
        }
    }

}