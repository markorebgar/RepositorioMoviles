package com.example.comsumicionapis

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comsumicionapis.databinding.ActivityMainBinding
import com.example.comsumicionapis.model.Datos
import com.example.comsumicionapis.recycler.MiAdaptador
import com.example.comsumicionapis.viewmodel.RecyclerViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import kotlin.getValue

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var miAdaptador : MiAdaptador

    private lateinit var misDatos : Datos

    private lateinit var main : ConstraintLayout
    private val miViewModel : RecyclerViewModel by viewModels()

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
        main = binding.root
        val mLayout = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = mLayout
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        binding.btnCargar.setOnClickListener {

            var tipoPerro = binding.tipoPerro.text.toString()

            if(tipoPerro == ""){
                Toast.makeText(this, "tienes que poner algo", Toast.LENGTH_SHORT).show()
            }else{
                miViewModel.devuelveFotos(tipoPerro)
            }

        }



                miViewModel.datos.observe(this@MainActivity) {

                    when(it.status){
                        "success" ->{
                            if(it.paginaActual==1){
                                misDatos = it
                                miAdaptador = MiAdaptador(DogRespuesta(it.status, it.message))
                                binding.recyclerView.adapter = miAdaptador


                            }else{
                                miAdaptador.notifyItemRangeInserted(it.paginaActual!!*10, it.message!!.size)
                            }

                        }
                        "error" ->{
                            Toast.makeText(this@MainActivity, "No hay perros con esa raza brodi",
                                Toast.LENGTH_LONG).show()
                        }
                    }
                }


        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var finalScroll : Boolean = false;
                if(mLayout.findLastVisibleItemPosition()%10 >= 9 && mLayout.findLastVisibleItemPosition()/10==(misDatos.paginaActual!!-1)){
                    finalScroll = true
                }
                if(finalScroll&& misDatos.paginaActual!! < misDatos.numPaginas!!){
                    Snackbar.make( main, "Si desea recuperar más fotos pulse: ", Snackbar.LENGTH_SHORT).setAction("Cargar más fotos", View.OnClickListener{miViewModel.scrollFotos()}).show()
                }
            }

        })
    }
}