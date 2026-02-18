package com.example.calculadorav2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadorav2.model.sampledata.CicloVidaModel
import com.example.calculadorav2.model.sampledata.Datos

class CicloVidaViewModel: ViewModel() {

    val miModelo = CicloVidaModel();

    private val _misDatos = MutableLiveData<Datos>()

    val misDatosObservables : LiveData<Datos> get() = _misDatos

    public fun uno (){
        _misDatos.value = miModelo.uno();
    }
    public fun dos (){
        _misDatos.value = miModelo.dos();
    }
    public fun tres (){
        _misDatos.value = miModelo.tres();
    }
    public fun cuatro (){
        _misDatos.value = miModelo.cuatro();
    }
    public fun cinco (){
        _misDatos.value = miModelo.cinco();
    }public fun seis (){
        _misDatos.value = miModelo.seis();
    }
    public fun siete (){
        _misDatos.value = miModelo.siete();
    }
    public fun ocho (){
        _misDatos.value = miModelo.ocho();
    }
    public fun nueve (){
        _misDatos.value = miModelo.nueve();
    }
    public fun cero (){
        _misDatos.value = miModelo.cero();
    }
    public fun multiplicar (){
        _misDatos.value = miModelo.multiplicar();
    }
    public fun dividir (){
        _misDatos.value = miModelo.dividir();
    }
    public fun sumar (){
        _misDatos.value = miModelo.sumar();
    }
    public fun restar (){
        _misDatos.value = miModelo.restar();
    }
    public fun clear (){
        _misDatos.value = miModelo.clear();
    }
    public fun igual (){
        _misDatos.value = miModelo.igual();
    }






}