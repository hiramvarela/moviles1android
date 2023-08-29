package com.example.pdm123.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.pdm123.R

object NavBarItems {
    val NavBarItems = listOf(
        BarItem(
            title = R.string.first_partial,
            image = Icons.Filled.Home,
            route = "FirstPartial"
        ),
        BarItem(
            title = R.string.second_partial,
            image = Icons.Filled.Airplay,
            route = "SecondPartial"
        ),
        BarItem(
            title = R.string.third_partial,
            image = Icons.Filled.Star,
            route = "ThirdPartial"
        )
    )

}