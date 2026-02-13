package com.example.juegodados

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    lateinit var main : ConstraintLayout
    lateinit var spinner : Spinner;

    lateinit var parImpar : MaterialButton
    lateinit var mm7 : MaterialButton

    lateinit var apuesta : EditText

    lateinit var div : CoordinatorLayout

    lateinit var saldo : TextView

    lateinit var miAdaptador : ArrayAdapter<String>

    lateinit var miImagen : ImageView

    private lateinit var miCorrutina: Job

    private lateinit var miOtraCorrutina: Job

    private lateinit var txdado1: TextView

    private lateinit var txdado2: TextView


    var opcion: String = "";

    var ap : Int? = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        parImpar = this.findViewById(R.id.ParImpar)
        mm7 = this.findViewById(R.id.MM7)
        spinner = this.findViewById(R.id.spinner)
        apuesta = this.findViewById(R.id.input)
        div = this.findViewById(R.id.div)
        saldo = this.findViewById(R.id.saldo)
        miImagen = this.findViewById(R.id.miImagen)
        miImagen.setImageResource(0);

        txdado1 = this.findViewById(R.id.dado1)
        txdado2 = this.findViewById(R.id.dado2)

        spinner.onItemSelectedListener = this


        parImpar.setOnClickListener {


            mm7.isChecked = false
            miAdaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,arrayOf("Par", "Impar"))
            spinner.adapter = miAdaptador


        }
        mm7.setOnClickListener {

            parImpar.isChecked = false
            miAdaptador = ArrayAdapter(this,android.R.layout.simple_spinner_item,arrayOf("Mayor o igual a 7", "Menor que 7"))
            spinner.adapter = miAdaptador



        }


        var lanzarDados : Button = this.findViewById<Button>(R.id.lanzarDados)
        main = this.findViewById(R.id.main)
        lanzarDados.setOnClickListener(this)




    }

    override fun onClick(v: View?) {

        if( mm7.isChecked || parImpar.isChecked){

            if(apuesta.text.toString().toIntOrNull() == null){

                Snackbar.make(div, "Ingrese un número válido", Snackbar.LENGTH_LONG).show();

            }else{

                if(apuesta.text.toString().toInt() <= 0 ){
                    Snackbar.make(div, "La apuesta no puede ser menor a 0 o 0", Snackbar.LENGTH_LONG).show();

                }else{

                    var ap = apuesta.text.toString().toInt();
                    var saldoNum = saldo.text.toString().toInt();

                    if(apuesta.text.toString().toInt() > saldoNum){
                        Snackbar.make(div, "La apuesta debe ser menor al saldo disponible", Snackbar.LENGTH_LONG).show();
                    }else{
                        Glide.with(this).load(R.drawable.dadosanimados).into(miImagen)
                        var contexto = this;
                        miCorrutina = lifecycleScope.launch {
                            doSomethingUsefulOne(3)


                            var dado1 = Random.nextInt(1, 6)
                            var dado2 = Random.nextInt(1, 6)

                            var suma = dado1 + dado2

                            var ganado = false;

                            if (opcion == "Par") {

                                if (suma % 2 == 0) {
                                    ganado = true;
                                }

                            } else if (opcion == "Impar") {
                                if (suma % 2 != 0) {
                                    ganado = true;
                                }

                            } else if (opcion == "Mayor o igual a 7") {
                                if (suma >= 7) {
                                    ganado = true;
                                }
                            } else {
                                if (suma < 7) {
                                    ganado = true;
                                }
                            }
                            var nuevoSaldo = 0
                            if (ganado) {
                                nuevoSaldo = ap + saldoNum
                                miImagen.setImageResource(R.drawable.ganardados)

                            } else {
                                nuevoSaldo = saldoNum - ap
                                miImagen.setImageResource(R.drawable.perderdados)

                            }
                            txdado1.text = dado1.toString()
                            txdado2.text = dado2.toString()

                            saldo.text = nuevoSaldo.toString();
                            miOtraCorrutina = lifecycleScope.launch {
                                doSomethingUsefulOne(1);

                                if(saldo.text.toString().toInt() <= 0){
                                    miImagen.setImageResource(R.drawable.bancarrota)

                                    var miAlert = AlertDialog.Builder(contexto);
                                    miAlert.setTitle("Juagndo a los dados")
                                    miAlert.setMessage("Estas arruinado. Debes dejar el juego")
                                    miAlert.setNegativeButton("Salir del juego",DialogInterface.OnClickListener{ e,w ->
                                        contexto.finish()
                                    } ).show()
                                }else{
                                    var miAlert = AlertDialog.Builder(contexto);
                                    miAlert.setTitle("Juagndo a los dados")
                                    miAlert.setMessage("¿Desea seguir jugando?")
                                    miAlert.setPositiveButton("Seguir jugando",null)
                                    miAlert.setNegativeButton("Salir del juego",DialogInterface.OnClickListener{ e,w ->
                                        contexto.finish()
                                    } )

                                        .show()
                                }






                            }
                        }


                    }


                }


            }












        }else{
            Snackbar.make(div, "Debe elegir una opción de juego", Snackbar.LENGTH_LONG).show();
        }



    }

    suspend fun doSomethingUsefulOne(x : Long): Int{
        delay(1000 * x);
        return 13
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        opcion = spinner.selectedItem.toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


}