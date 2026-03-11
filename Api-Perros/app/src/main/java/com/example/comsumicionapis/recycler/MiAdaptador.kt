package com.example.comsumicionapis.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comsumicionapis.DogRespuesta
import com.example.comsumicionapis.R
import com.example.comsumicionapis.model.Datos

class MiAdaptador(var misDatos: DogRespuesta) : RecyclerView.Adapter<MiVista>() {

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
        val url = misDatos.message!!.get(position)

        Glide.with(holder.itemView.context).load(url).into(holder.marcoImagen)


    }
    override fun getItemCount(): Int {
        return misDatos.message!!.size
    }
}