package com.example.mshop2

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.mshop2.databinding.ActivityLoginBinding
import com.example.mshop2.model.MiViewModel
import kotlinx.coroutines.launch
import kotlin.getValue

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private lateinit var accessToken : String
    private val miViewModel : MiViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.enviar.setOnClickListener {
            var email = binding.emailText.text.toString()
            var password = binding.passwordText.text.toString()
            if(password == "" || email == ""){
                binding.error.text = "El email y/o la contraseña no puede estar vacio"
            }else{
                miViewModel.recuperarToken(email, password)

            }
        }
        lifecycleScope.launch {
            miViewModel.accessToken.collect { token ->

                when(token){

                    "" -> {}
                    "error" ->{binding.error.text = "El email y/o la contraseña no son correctas" }
                    else ->{
                        accessToken = token
                        binding.error.text = "EXITO"
                        val myIntentVuelta = Intent()
                        myIntentVuelta.putExtra("token", accessToken)
                        setResult(RESULT_OK, myIntentVuelta)
                        finish()
                    }
                }
            }
        }
    }
}