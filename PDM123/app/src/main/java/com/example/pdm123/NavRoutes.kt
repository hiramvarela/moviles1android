package com.example.pdm123

/**
 * Lista de rutas a las cuales se puede navegar dentro de la aplicacion
 */

sealed class NavRoutes(val route: String) {
    object firstPartial : NavRoutes("firstpartial")
    object secondPartial : NavRoutes("secondpartial")
    object thirdPartial : NavRoutes("thirdpartial")
}