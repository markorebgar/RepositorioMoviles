package com.example.composeperros.model

data class Datos(var status: String, var razasYSubrazas : Map<String, List<String>>?, var fotos: List<String>? )
