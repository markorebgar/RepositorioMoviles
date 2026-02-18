package com.example.calculadorav2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadorav2.databinding.ActivityMainBinding
import com.example.calculadorav2.viewmodel.CicloVidaViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val miViewModel : CicloVidaViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnNumero0.setOnClickListener{
            miViewModel.cero()

        }
        binding.btnNumero1.setOnClickListener{
            miViewModel.uno()

        }
        binding.btnNumero2.setOnClickListener{
            miViewModel.dos()

        }
        binding.btnNumero3.setOnClickListener{
            miViewModel.tres()

        }
        binding.btnNumero4.setOnClickListener{
            miViewModel.cuatro()

        }
        binding.btnNumero5.setOnClickListener{
            miViewModel.cinco()

        }
        binding.btnNumero6.setOnClickListener{
            miViewModel.seis()

        }
        binding.btnNumero7.setOnClickListener{
            miViewModel.siete()

        }
        binding.btnNumero8.setOnClickListener{
            miViewModel.ocho()

        }
        binding.btnNumero9.setOnClickListener{
            miViewModel.nueve()

        }
        binding.btnIgual.setOnClickListener{
            miViewModel.igual()

        }
        binding.btnRestar.setOnClickListener{
            miViewModel.restar()

        }
        binding.btnSumar.setOnClickListener{
            miViewModel.sumar()

        }
        binding.btnMultiplicar.setOnClickListener{
            miViewModel.multiplicar()

        }
        binding.btnDividir.setOnClickListener{
            miViewModel.dividir()

        }
        binding.btnClear.setOnClickListener{
            miViewModel.clear()

        }

        miViewModel.misDatosObservables.observe(this,{
                misDatosRecibidos ->



            binding.resultado.text = misDatosRecibidos.textoAbajo.toString()
            binding.cambiable.text = misDatosRecibidos.textoArriba.toString()

            if(misDatosRecibidos.mostrarToast){
                Toast.makeText(this,"no puedes poner una operacion despues de una operacion", Toast.LENGTH_SHORT).show()
            }



        })


    }
}