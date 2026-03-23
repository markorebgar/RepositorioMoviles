package com.example.tabsfragmentadosmenu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tabsfragmentadosmenu.model.CycleLifeModelFragment
import com.example.tabsfragmentadosmenu.model.CycleLifeModelMain
import com.example.tabsfragmentadosmenu.model.DatosFragmentos
import com.example.tabsfragmentadosmenu.model.DatosMain
import kotlinx.coroutines.launch

class CycleLifeViewModelFragment : ViewModel() {

    val cicloVidaModel = CycleLifeModelFragment()
    private var _datos = MutableLiveData<DatosFragmentos>(DatosFragmentos(null.toString(),null.toString()));

    val datos: LiveData<DatosFragmentos> get() = _datos


    fun guardarResultado(res : String){
        viewModelScope.launch {
            _datos.value = cicloVidaModel.guardarResultado(res);
        }

    }

}