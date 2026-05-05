package com.example.mshop2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.mshop2.databinding.ActivityMainBinding
import com.example.mshop2.model.MiViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val miViewModel : MiViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var miLanzador : ActivityResultLauncher<Intent>
    private var miContrato = ActivityResultContracts.StartActivityForResult()



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




        miLanzador = registerForActivityResult(miContrato){
            when (it.resultCode){
                RESULT_OK -> {
                    miViewModel.setAccessToken(it.data?.getStringExtra("token") ?: "")
                }
            }
        }
        if (miViewModel.accessToken.value.isEmpty()) {
            val intent = Intent(this, LoginActivity::class.java)
            miLanzador.launch(intent)
        }



    }
}