package com.example.quizmatematico2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    var numeroRandom = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btngenNum = findViewById<Button>(R.id.btnAleatorio);
        var texto = findViewById<TextView>(R.id.htext)

        var chkdivi2 = findViewById<CheckBox>(R.id.Chkdivisible2);
        var chkdivi3 = findViewById<CheckBox>(R.id.Chkdivisible3);
        var chkdivi5 = findViewById<CheckBox>(R.id.Chkdivisible5);
        var chkdivi10 = findViewById<CheckBox>(R.id.Chkdivisible10);
        var chkNOdivi = findViewById<CheckBox>(R.id.ChkNOdivisible);

        var comprobar = findViewById<Button>(R.id.btnComprobar);
        var res = findViewById<TextView>(R.id.resul);
        var imagen = findViewById<ImageView>(R.id.imagen)

        btngenNum.setOnClickListener {

            var n = Random.nextInt(1000, 2001);
            numeroRandom = n
            texto.text = "¿Entre qué números es divisible";
            texto.text = "${texto.text} ${numeroRandom.toString()} ?";

        }
        comprobar.setOnClickListener {

            var Error : Boolean = false;




            if (chkdivi2.isChecked || chkdivi3.isChecked || chkdivi5.isChecked || chkdivi10.isChecked || chkNOdivi.isChecked) {

                if(numeroRandom % 2 == 0 && !chkdivi2.isChecked){
                    Error = true;
                }
                if(numeroRandom % 2 != 0 && chkdivi2.isChecked){
                    Error = true;
                }
                if(numeroRandom % 3 == 0 && !chkdivi3.isChecked){
                    Error = true;
                }
                if(numeroRandom % 3 != 0 && chkdivi3.isChecked){
                    Error = true;
                }
                if(numeroRandom % 5 == 0 && !chkdivi5.isChecked){
                    Error = true;
                }
                if(numeroRandom % 5 != 0 && chkdivi5.isChecked){
                    Error = true;
                }
                if(numeroRandom % 10 == 0 && !chkdivi10.isChecked){
                    Error = true;
                }
                if(numeroRandom % 10 != 0 && chkdivi10.isChecked){
                    Error = true;
                }
                if(chkNOdivi.isChecked){
                    if(numeroRandom % 2 == 0 || numeroRandom % 3 == 0 || numeroRandom % 5 == 0 || numeroRandom % 10 == 0){
                        Error = true
                    }
                }
                if(Error){
                    res.text = "Error";
                }else{
                    res.text = "Correcto";
                }

            } else {
                res.text = "Debe escoger al menos una de las opciones";
            }

            if(res.text != "Correcto"){
                imagen.setImageResource(R.drawable.mal);
            }else{
                imagen.setImageResource(R.drawable.bien);
            }

        }


    }


}