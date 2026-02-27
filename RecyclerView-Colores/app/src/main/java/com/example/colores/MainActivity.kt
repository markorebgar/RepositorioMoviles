package com.example.colores

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope

import kotlinx.coroutines.launch
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.colores.databinding.ActivityMainBinding
import com.example.colores.recycler.MiAdaptador
import com.example.colores.viewmodel.RecyclerViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var miAdaptador : MiAdaptador
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

        miViewModel.retornarLista()

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED){
                miViewModel.datos.collect {

                    miAdaptador = MiAdaptador(it)
                    binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity,
                        LinearLayoutManager.VERTICAL, false)
                    binding.recyclerView.adapter = miAdaptador

                    val midividirItemDecoration =
                        DividerItemDecoration(
                            this@MainActivity,
                            DividerItemDecoration.VERTICAL
                        )
                    binding.recyclerView.addItemDecoration(midividirItemDecoration)

                }
            }

        }



    }
}