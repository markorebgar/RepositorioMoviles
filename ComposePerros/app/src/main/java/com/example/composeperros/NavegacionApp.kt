package com.example.composeperros

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun navegacion(){
    val miNavController = rememberNavController()
    NavHost(miNavController, startDestination = "Pantalla inicial"){
        composable("Pantalla inicial"){
            listadoRazas(miNavController)
        }
        composable("DetallePerro/{raza}/{subraza}"){
            val miRaza = it.arguments?.getString("raza") ?: ""
            val miSubRaza = it.arguments?.getString("subraza") ?: ""
            listadoImagenes(miRaza, miSubRaza, miNavController)
        }
    }

}