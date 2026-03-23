package com.example.tabsfragmentadosmenu.model


class CycleLifeModelFragment {

    public suspend fun guardarResultado (res : String) : DatosFragmentos{
        return DatosFragmentos("ok", res)
    }

}