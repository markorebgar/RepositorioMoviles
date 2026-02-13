package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var numero1 = this.findViewById<EditText>(R.id.numero1);

        var numero2 = this.findViewById<EditText>(R.id.numero2);
        var resultado = this.findViewById<TextView>(R.id.res);

        var botonSumar : Button = this.findViewById<Button>(R.id.btmas);
        var botonRestar : Button = this.findViewById<Button>(R.id.btmenos);
        var botonMultiplicar : Button = this.findViewById<Button>(R.id.btasterisco);
        var botonDividir : Button = this.findViewById<Button>(R.id.btdividir);

        botonSumar.setOnClickListener {sumar(numero1, numero2, resultado)};
        botonRestar.setOnClickListener {restar(numero1, numero2, resultado)};
        botonMultiplicar.setOnClickListener {multiplicar(numero1, numero2, resultado)};
        botonDividir.setOnClickListener {dividir(numero1, numero2, resultado)};

    }



    fun sumar(n1 : EditText, n2 : EditText, res : TextView){
        var numero1int : Double = n1.text.toString().toDouble();
        var numero2int : Double = n2.text.toString().toDouble();


        res.text = (numero1int + numero2int).toString();
    }

    fun restar(n1 : EditText, n2 : EditText, res : TextView){
        var numero1int : Double = n1.text.toString().toDouble();
        var numero2int : Double = n2.text.toString().toDouble();


        res.text = (numero1int - numero2int).toString();
    }
    fun multiplicar(n1 : EditText, n2 : EditText, res : TextView){
        var numero1int : Double = n1.text.toString().toDouble();
        var numero2int : Double = n2.text.toString().toDouble();


        res.text = (numero1int * numero2int).toString();
    }
    fun dividir(n1 : EditText, n2 : EditText, res : TextView){
        var numero1int : Double = n1.text.toString().toDouble();
        var numero2int : Double = n2.text.toString().toDouble();


        res.text = (numero1int / numero2int).toString();
    }






}