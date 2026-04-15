package com.example.composecalculadora

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MiViewModel : ViewModel() {
    private val miEstado = MiEstado()
    private val _numeroUno = MutableStateFlow<String>("")
    val numeroUno : StateFlow<String> get() = _numeroUno
    private val _numeroDos = MutableStateFlow<String>("")
    val numeroDos : StateFlow<String> get() = _numeroDos

    private val _res = MutableStateFlow<Double>(0.0)
    val res : StateFlow<Double> get() = _res

    fun setNumeroUno(value: String) {
        _numeroUno.value = value
    }

    fun setNumeroDos(value: String) {
        _numeroDos.value = value
    }

    fun sumar(){
        _res.value = miEstado.sumar(numeroUno.value.toDoubleOrNull() ?: 0.0, numeroDos.value.toDoubleOrNull() ?: 0.0)
    }
    fun restar(){
        _res.value = miEstado.restar(numeroUno.value.toDoubleOrNull() ?: 0.0, numeroDos.value.toDoubleOrNull() ?: 0.0)
    }
    fun multiplicar(){
        _res.value = miEstado.multiplicar(numeroUno.value.toDoubleOrNull() ?: 0.0, numeroDos.value.toDoubleOrNull() ?: 0.0)
    }
    fun dividir(){
        _res.value = miEstado.dividir(numeroUno.value.toDoubleOrNull() ?: 0.0, numeroDos.value.toDoubleOrNull() ?: 0.0)
    }
}