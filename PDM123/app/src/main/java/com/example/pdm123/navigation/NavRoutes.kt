package com.example.pdm123.navigation

/**
 * Lista de rutas a las cuales se puede navegar dentro de la aplicacion
 */

sealed class NavRoutes(val route: String) {
    object FirstPartialView : NavRoutes("FirstPartial")
    object SecondPartialView : NavRoutes("SecondPartial")
    object ThirdPartialView : NavRoutes("ThirdPartial")
    object PadelScoreView : NavRoutes("PadelScore")
    object EvenOrOddView : NavRoutes("EvenOrOdd")
    object CardsView : NavRoutes("Cards")

    object NumberComparator : NavRoutes("Number")
    object Salon : NavRoutes("Salon")
    object Apples : NavRoutes("Apples")
}