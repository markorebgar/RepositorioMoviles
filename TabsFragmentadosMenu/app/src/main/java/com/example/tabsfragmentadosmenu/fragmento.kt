package com.example.tabsfragmentadosmenu

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.tabsfragmentadosmenu.viewmodel.CycleLifeViewModelFragment
import com.example.tabsfragmentadosmenu.viewmodel.CycleLifeViewModelMain
import kotlin.getValue

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
/**
 * A simple [Fragment] subclass.
 * Use the [fragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragmento : Fragment() {
    // TODO: Rename and change types of parameters
    private var numeroRandom: Int = 0

    private lateinit var myView : View

    private val miViewModel : CycleLifeViewModelFragment by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            numeroRandom = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_fragmento, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var miRadioGrupo = myView.findViewById<RadioGroup>(R.id.radioGrupo)
        var btnValidar = myView.findViewById<Button>(R.id.btnValidar)
        var res = myView.findViewById<TextView>(R.id.bisiestoResultado)


        miViewModel.datos.observe(viewLifecycleOwner){
            if (it.estado == "ok"){
                res.text = it.resultado
                when(it.resultado){
                    "Correcto" -> res.setTextColor(Color.GREEN)
                    "Error" -> res.setTextColor(Color.RED)
                    else -> res.setTextColor(Color.BLUE)
                }
            }
        }

        btnValidar.setOnClickListener {
            var bisiesto = false;
            if(numeroRandom % 4 == 0){
                bisiesto = true;
                if(numeroRandom % 100 == 0){
                    bisiesto = false;
                    if(numeroRandom % 400 == 0){
                        bisiesto = true;
                    }
                }
            }

            when(miRadioGrupo.checkedRadioButtonId){

                R.id.rdSi ->{
                    if(bisiesto){
                        miViewModel.guardarResultado("Correcto")
                    }else{
                        miViewModel.guardarResultado("Error")

                    }

                }
                R.id.rdNo-> {
                    if(bisiesto){
                        miViewModel.guardarResultado("Error")
                    }else{
                        miViewModel.guardarResultado("Correcto")

                    }

                }
                -1 -> {
                    miViewModel.guardarResultado("Debe escoger una de las opciones")
                    res.setTextColor(Color.BLUE);
                }




            }


        }



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragmento.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(numeroRandom: Int) =
            fragmento().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, numeroRandom)
                }
            }
    }
}