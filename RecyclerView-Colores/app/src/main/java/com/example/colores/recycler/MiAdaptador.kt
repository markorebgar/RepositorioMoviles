package com.example.colores.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.colores.R
import com.example.colores.model.Datos

class MiAdaptador(var misDatos : Datos) : RecyclerView.Adapter<MiVista>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MiVista {
        var miVista = LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent, false)
        return MiVista(miVista)
    }

    override fun onBindViewHolder(
        holder: MiVista,
        position: Int
    ) {
        val color = misDatos.lista.get(position)

        holder.nombreColor.text = color.nombreColor
        holder.hexColor.text = color.hexColor
        val colorInt : Int = color.hexColor.toColorInt();

        holder.itemView.setBackgroundColor(colorInt)


    }
    override fun getItemCount(): Int {
        return misDatos.lista.size
    }
}