package com.example.colores.recycler

import android.text.Layout
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.colores.R

class MiVista(miFila : View) : RecyclerView.ViewHolder(miFila) {
    var nombreColor = miFila.findViewById<TextView>(R.id.nombreColor)
    var hexColor = miFila.findViewById<TextView>(R.id.hexColor)


}