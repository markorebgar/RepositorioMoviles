package com.example.comsumicionapis.recycler

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.comsumicionapis.R

class MiVista(miFila : View) : RecyclerView.ViewHolder(miFila) {
    var marcoImagen = miFila.findViewById<ImageView>(R.id.marcoImagen)
}