package com.example.tabsfragmentadosmenu.model

import kotlin.random.Random

class CycleLifeModelMain {
    var misDatos = DatosMain("ok", 0, 0, "Elije número");

    public suspend fun generarRandom () : DatosMain{
        misDatos.numeroRandom = Random.nextInt(1900,2200)
        return misDatos;
    }
    public suspend fun guardarTab (tabSeleccionado : Int) : DatosMain{
        misDatos.tabSeleccionado = tabSeleccionado
        return misDatos
    }
    public suspend fun guardarTitulo (titulo : String) : DatosMain{
        misDatos.titulo = titulo
        return misDatos
    }


}