package com.example.tabsfragmentadosmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.tabsfragmentadosmenu.viewmodel.CycleLifeViewModelMain
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlin.getValue
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var main : View
    private lateinit var mtMain: MaterialToolbar

    private lateinit var btnGenerar: Button

    private lateinit var txtNumeroRandom: TextView

    private lateinit var myTab : TabLayout

    private var numeroRandom : Int = 0;

    private var tabNumero : Int = 0

    private val miViewModel : CycleLifeViewModelMain by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mtMain = findViewById(R.id.mtMain)
        btnGenerar = findViewById(R.id.btnGenerar)
        txtNumeroRandom = findViewById(R.id.numeroRandom)
        myTab = findViewById(R.id.tabLayout)
        main = findViewById(R.id.main)

        mtMain.title = miViewModel.retornarTitulo()
        myTab.getTabAt(miViewModel.retornarPosicion())?.select()

        myTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab){
                miViewModel.guardarTab(tab.position)
                seleccionarTab(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                miViewModel.guardarTab(tab.position)
                seleccionarTab(tab.position)
            }
        })

        setSupportActionBar(mtMain)

        btnGenerar.setOnClickListener {
            miViewModel.retornarRandom()
            seleccionarTab(tabNumero)

        }

        miViewModel.datos.observe(this@MainActivity){
            tabNumero = it.tabSeleccionado
            if (it.estado == "ok"){
                txtNumeroRandom.text = it.numeroRandom.toString();
                numeroRandom = it.numeroRandom
                mtMain.title = it.titulo
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        mtMain.inflateMenu(R.menu.mimenu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.title){
            "salir" -> this.finish()

        }

        return super.onOptionsItemSelected(item)
    }
    fun seleccionarTab(posicion: Int){
        if(posicion == 0){
            miViewModel.guardarTitulo("Bisiesto")
        }else{
            miViewModel.guardarTitulo("Divisible")
        }
        if(numeroRandom != 0){
            val myFragmentManager : FragmentManager = supportFragmentManager
            val myFragmentTransaction = myFragmentManager.beginTransaction()
            lateinit var miFragment : Fragment;
            when(posicion){
                0 ->{
                    miFragment = fragmento.newInstance(numeroRandom)
                }
                1->{
                    miFragment = divisiblefragmento.newInstance(numeroRandom)
                }
            }
            myFragmentTransaction.replace(R.id.myFrame, miFragment).commit()

        }else{
            Snackbar.make(main, "elije numero primero", Snackbar.LENGTH_SHORT).show()
        }
    }
}