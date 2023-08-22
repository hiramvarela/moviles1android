package com.example.pdm123

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object NavBarItems {
    val NavBarItems = listOf(
        BarItem(
            title = "Primer parcial",
            image = Icons.Filled.Home,
            route = "firstpartial"
        ),
        BarItem(
            title = "Segundo parcial",
            image = Icons.Filled.Airplay,
            route = "secondpartial"
        ),
        BarItem(
            title = "Tercer parcial",
            image = Icons.Filled.Star,
            route = "thirdpartial"
        )
    )

}