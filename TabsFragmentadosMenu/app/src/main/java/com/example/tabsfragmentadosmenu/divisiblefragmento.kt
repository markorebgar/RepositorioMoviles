package com.example.tabsfragmentadosmenu

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.example.tabsfragmentadosmenu.viewmodel.CycleLifeViewModelFragment
import kotlin.getValue

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
/**
 * A simple [Fragment] subclass.
 * Use the [fragmento.newInstance] factory method to
 * create an instance of this fragment.
 */
class divisiblefragmento : Fragment() {
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
        myView = inflater.inflate(R.layout.fragment_divisiblefragmento, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var chkdivi2 = myView.findViewById<CheckBox>(R.id.Chkdivisible2);
        var chkdivi3 =  myView.findViewById<CheckBox>(R.id.Chkdivisible3);
        var chkdivi5 = myView.findViewById<CheckBox>(R.id.Chkdivisible5);
        var chkdivi10 = myView.findViewById<CheckBox>(R.id.Chkdivisible10);
        var chkNOdivi = myView.findViewById<CheckBox>(R.id.ChkNOdivisible);
        var btnDivisibleValidar = myView.findViewById<Button>(R.id.btnDivisibleValidar)

        var resDivisible = myView.findViewById<TextView>(R.id.divisibleResultado)

        miViewModel.datos.observe(viewLifecycleOwner){
            if (it.estado == "ok"){
                resDivisible.text = it.resultado
                when(it.resultado){
                    "Correcto" -> resDivisible.setTextColor(Color.GREEN)
                    "Error" -> resDivisible.setTextColor(Color.RED)
                    else -> resDivisible.setTextColor(Color.BLUE)
                }
            }
        }

        btnDivisibleValidar.setOnClickListener {

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
                    miViewModel.guardarResultado("Error")
                }else{
                    miViewModel.guardarResultado("Correcto")
                }

            } else {
                miViewModel.guardarResultado("Debe escoger al menos una de las opciones")
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
            divisiblefragmento().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, numeroRandom)
                }
            }
    }
}