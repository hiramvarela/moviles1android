package com.example.pdm123.navigation

import androidx.compose.ui.graphics.vector.ImageVector

//Esta es una clase de datos para los elementos del menu que aparece abajo
data class BarItem(
    // Titulo de la opcion
    val title : Int,
    // Icono de la opcion del menu
    val image : ImageVector,
    // Ruta a la cual se va a dirigir la opcion
    val route : String
)
