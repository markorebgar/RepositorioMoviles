package com.example.composeperros

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage


@Composable
fun listadoRazas(navController: NavController){
    val miViewModel: ListaViewModel = viewModel()
    val misDatos = miViewModel.misDatos.collectAsState().value
    val listaMap = misDatos.razasYSubrazas

    var miLista : List<Item> = listaMap?.flatMap { entry ->
        var raza = entry.key
        var subrazas = entry.value

        if(subrazas.isEmpty()){
            listOf(Item.Raza(raza))
        }else{

            subrazas.map { sub ->
                Item.Subraza(raza, sub)
            }

        }

    } ?: emptyList()


    Column(modifier = Modifier.fillMaxSize().padding(vertical = 40.dp)) {
        Text(text = "Escoge tu raza/subraza, raza en blanco (sin subraza) subraza en gris",
            modifier = Modifier.fillMaxWidth().height(80.dp))
        LazyColumn{
            items(miLista){item ->

                when(item){

                    is Item.Raza ->{
                        var vacio = ""
                        Text(text = "Raza: " + item.nombre, modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                            .height(50.dp)
                            .border(2.dp, color = Color.Red)
                            .clickable{
                                navController.navigate("DetallePerro/${item.nombre}/$vacio")
                            })
                    }
                    is Item.Subraza -> {
                        Text(text = "Raza: "+item.raza+", Subraza: "+ item.nombre, modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Gray)
                            .height(50.dp)
                            .border(1.dp, color = Color.Red)
                            .clickable {
                                navController.navigate("DetallePerro/${item.raza}/${item.nombre}")
                            })
                    }

                }

            }
       }

    }



}

@Composable
fun listadoImagenes(raza: String, subraza: String, navController: NavController){
    val miViewModel: ListaViewModel = viewModel()
    if(subraza == ""){
        miViewModel.recuperarFotosDeRaza(raza)
    }else{
        miViewModel.recuperarFotosDeSubraza(raza,subraza)
    }

    val misDatos = miViewModel.misDatos.collectAsState().value
    val misFotos = misDatos.fotos


    Column(modifier = Modifier.fillMaxSize().padding(vertical = 40.dp)) {
        Text(text = "Raza: "+raza +" Subraza: " + if(subraza =="") "(no es subraza)" else subraza,
            modifier = Modifier.fillMaxWidth().height(80.dp))
        Button(onClick = {
            navController.navigate("Pantalla inicial")
        }) {
            Text(text = "Volver")
        }
        LazyColumn(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            items(misFotos ?: emptyList()){item ->

                AsyncImage(
                    model = item,
                    contentDescription = "Raza: $raza Subraza: $subraza",
                )


            }
        }



    }






}