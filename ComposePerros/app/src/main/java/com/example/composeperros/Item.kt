package com.example.composeperros

sealed class Item {

    data class Raza(val nombre: String) : Item()

    data class Subraza(val raza: String, val nombre: String) : Item()

}