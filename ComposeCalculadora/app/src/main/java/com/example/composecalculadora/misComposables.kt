package com.example.composecalculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun calculadora(){
    val miViewModel: MiViewModel = viewModel()

    val numeroUno by miViewModel.numeroUno.collectAsState()
    val numeroDos by miViewModel.numeroDos.collectAsState()
    var total = miViewModel.res.collectAsState()


    Box(modifier = Modifier.fillMaxHeight(0.5f).offset(y = 30.dp)){
        Column() {
            Row(modifier = Modifier.height(100.dp).fillMaxWidth().background(color = Color.Yellow)) {

                Text(text = "Numero 1:", fontSize = 30.sp, textAlign = TextAlign.Center, modifier = Modifier.size(200.dp, 200.dp).offset(y = 30.dp))

                TextField(
                    value = numeroUno,
                    onValueChange ={
                        //Log.e("COMPOSE", "eSTOY TECLEANDO")
                        miViewModel.setNumeroUno(it)},
                    placeholder ={Text("Inserte un numero")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.fillMaxSize()
                )
            }
            Row(modifier = Modifier.height(100.dp).fillMaxWidth().background(color = Color.Blue)) {

                Text(text = "Numero 2:", fontSize = 30.sp, textAlign = TextAlign.Center, modifier = Modifier.size(200.dp, 200.dp).offset(y = 30.dp))

                TextField(
                    value = numeroDos,
                    onValueChange ={
                        //Log.e("COMPOSE", "eSTOY TECLEANDO")
                        miViewModel.setNumeroDos(it)},
                    placeholder ={Text("Inserte un numero")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier.fillMaxSize()
                )

            }
            Row(modifier = Modifier.height(100.dp).fillMaxWidth().background(color = Color.Red)) {

                Button(onClick = {
                    miViewModel.sumar()
                    miViewModel.setNumeroUno("")
                    miViewModel.setNumeroDos("")

                }, modifier = Modifier.height(50.dp).offset(y = 30.dp, x = 30.dp)) {
                    Text(text = "+")
                }

                Button(onClick = {
                    miViewModel.restar()
                    miViewModel.setNumeroUno("")
                    miViewModel.setNumeroDos("")
                }, modifier = Modifier.height(50.dp).offset(y = 30.dp, x = 80.dp)) {
                    Text(text = "-")
                }
                Button(onClick = {
                    miViewModel.multiplicar()
                    miViewModel.setNumeroUno("")
                    miViewModel.setNumeroDos("")
                }, modifier = Modifier.height(50.dp).offset(y = 30.dp, x = 120.dp)) {
                    Text(text = "*")
                }
                Button(onClick = {
                    miViewModel.dividir()
                    miViewModel.setNumeroUno("")
                    miViewModel.setNumeroDos("")
                }, modifier = Modifier.height(50.dp).offset(y = 30.dp, x = 160.dp)) {
                    Text(text = "/")
                }

            }
            Column(modifier = Modifier.height(100.dp).fillMaxWidth().background(color = Color.Cyan)) {
                Text(text = total.value.toString(), fontSize = 70.sp, textAlign = TextAlign.Center)
            }



        }




    }


}