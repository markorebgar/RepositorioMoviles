package com.example.quizmatematico

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var random1 : Int = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var switch1 = findViewById<Switch>(R.id.switch1);
        var generarRandom = findViewById<Button>(R.id.hgenerarNumero);
        var hrandom = findViewById<TextView>(R.id.numAl) ;
        var hbotones = findViewById<RadioGroup>(R.id.grupo);
        var confirmar = findViewById<Button>(R.id.hcomprobarRes);
        var res = findViewById<TextView>(R.id.resul)


        switch1.setOnClickListener {
            if(switch1.isChecked){

                window.decorView.setBackgroundColor(Color.YELLOW);

            }else {
                window.decorView.setBackgroundColor(Color.WHITE);
            }
        }

        generarRandom.setOnClickListener {
            val numeroRandom = Random.nextInt(1900, 2501);
            random1 = numeroRandom;
            hrandom.text = numeroRandom.toString();
        }



        confirmar.setOnClickListener {

            var bisiesto = false;



            if(random1 % 4 == 0){
                bisiesto = true;
                if(random1 % 100 == 0){
                    bisiesto = false;
                    if(random1 % 400 == 0){
                        bisiesto = true;
                    }
                }
            }

            when(hbotones.checkedRadioButtonId){



                R.id.r1si ->{
                    if(bisiesto){
                        res.text = "Correcto";
                        res.setTextColor(Color.GREEN);
                    }else{
                        res.text = "Error";
                        res.setTextColor(Color.RED);

                    }

                }
                R.id.r2no-> {
                    if(bisiesto){
                        res.text = "Error";
                        res.setTextColor(Color.RED);
                    }else{
                        res.text = "Correcto";
                        res.setTextColor(Color.GREEN);

                    }

                }
                -1 -> {
                    res.text = "Debe escoger una de las opciones";
                    res.setTextColor(Color.BLUE);
                }



            }

        }












    }





}