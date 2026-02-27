package com.example.colores.model

class RecyclerModel {

    var colores = mutableListOf<Colores>(Colores("Rojo", "#FF0000"),
        Colores("Verde", "#00FF00"),
        Colores("Azul", "#0000FF"),
        Colores("Amarillo", "#FFFF00"),
        Colores("Cian", "#00FFFF"),
        Colores("Magenta", "#FF00FF"),
        Colores("Negro", "#000000"),
        Colores("Blanco", "#FFFFFF"),
        Colores("Gris", "#808080"),
        Colores("Gris Claro", "#D3D3D3"),
        Colores("Gris Oscuro", "#A9A9A9"),

        Colores("Naranja", "#FFA500"),
        Colores("Naranja Oscuro", "#FF8C00"),
        Colores("Rosa", "#FFC0CB"),
        Colores("Rosa Fuerte", "#FF69B4"),
        Colores("Morado", "#800080"),
        Colores("Violeta", "#8A2BE2"),
        Colores("Lila", "#C8A2C8"),
        Colores("Marrón", "#A52A2A"),
        Colores("Beige", "#F5F5DC"),
        Colores("Turquesa", "#40E0D0"),

        Colores("Azul Marino", "#000080"),
        Colores("Azul Cielo", "#87CEEB"),
        Colores("Azul Acero", "#4682B4"),
        Colores("Azul Real", "#4169E1"),
        Colores("Azul Medianoche", "#191970"),

        Colores("Verde Lima", "#32CD32"),
        Colores("Verde Oscuro", "#006400"),
        Colores("Verde Oliva", "#808000"),
        Colores("Verde Esmeralda", "#50C878"),
        Colores("Verde Menta", "#98FF98"),

        Colores("Rojo Oscuro", "#8B0000"),
        Colores("Rojo Coral", "#FF4040"),
        Colores("Rojo Tomate", "#FF6347"),
        Colores("Rojo Carmesí", "#DC143C"),

        Colores("Dorado", "#FFD700"),
        Colores("Plateado", "#C0C0C0"),
        Colores("Bronce", "#CD7F32"),
        Colores("Cobre", "#B87333"),

        Colores("Lavanda", "#E6E6FA"),
        Colores("Salmón", "#FA8072"),
        Colores("Chocolate", "#D2691E"),
        Colores("Perla", "#EAE0C8"))


    public suspend fun retornarLista(): Datos{
        return Datos("ok", colores)
    }

}