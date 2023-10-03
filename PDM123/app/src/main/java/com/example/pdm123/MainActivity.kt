package com.example.pdm123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pdm123.firstpartial.ApplesView
import com.example.pdm123.firstpartial.ApplesViewModel
import com.example.pdm123.firstpartial.CardsView
import com.example.pdm123.firstpartial.CardsViewModel
import com.example.pdm123.firstpartial.EvenOddView

import com.example.pdm123.firstpartial.EvenOddViewModel
import com.example.pdm123.firstpartial.FirstPartialView
import com.example.pdm123.firstpartial.NumberComparatorView
import com.example.pdm123.firstpartial.NumberComparatorViewModel
import com.example.pdm123.firstpartial.PadelScoreView
import com.example.pdm123.firstpartial.SalonView
import com.example.pdm123.firstpartial.SalonViewModel
import com.example.pdm123.navigation.NavBarItems
import com.example.pdm123.navigation.NavRoutes
import com.example.pdm123.secondpartial.Listas.ListasView
import com.example.pdm123.secondpartial.Listas.ListasViewModel
import com.example.pdm123.secondpartial.Onboarding.OnboardingView
import com.example.pdm123.secondpartial.Qr.QrView
import com.example.pdm123.secondpartial.SecondPartialView
import com.example.pdm123.thirdpartial.ThirdPartialView
import com.example.pdm123.ui.theme.PDM123Theme
import com.google.accompanist.pager.ExperimentalPagerApi
@androidx.camera.core.ExperimentalGetImage
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDM123Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    MainScreen()
                    OnboardingView()
                }
            }
        }
    }
}
@androidx.camera.core.ExperimentalGetImage
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("ULSA CHIHUAHUA") }) },
        content = {
            it
            NavigationHost(navController = navController)
        },
        bottomBar = { BottomNavigationBar(navController = navController) }
    )

}

/*
Esta funcion va a ser encargada de manejar los tabs de la aplicacion
 */
@androidx.camera.core.ExperimentalGetImage
@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.FirstPartialView.route) {
        composable(NavRoutes.FirstPartialView.route) {
            FirstPartialView(navController = navController)
        }
        composable(NavRoutes.SecondPartialView.route) {
            SecondPartialView(navController = navController)
        }
        composable(NavRoutes.ThirdPartialView.route) {
            ThirdPartialView()
        }
        composable(NavRoutes.PadelScoreView.route) {
            PadelScoreView()
        }
        composable(NavRoutes.EvenOrOddView.route) {
            EvenOddView(navController = navController, viewModel = EvenOddViewModel())
        }
        composable(NavRoutes.CardsView.route) {
            CardsView(navController = navController, viewModel = CardsViewModel())
        }
        composable(NavRoutes.NumberComparator.route) {
            NumberComparatorView(navController = navController, viewModel = NumberComparatorViewModel())
        }
        composable(NavRoutes.Salon.route) {
            SalonView(navController = navController, viewModel = SalonViewModel())
        }
        composable(NavRoutes.Apples.route) {
            ApplesView(navController = navController, viewModel = ApplesViewModel())
        }
        composable(NavRoutes.Qr.route) {
           QrView()
        }
        composable(NavRoutes.Lists.route) {
            ListasView(navController = navController, viewModel = ListasViewModel())
        }
        composable(NavRoutes.MainActivity.route) {
            MainActivity()
        }

    }

}

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.NavBarItems.forEach { navItem ->

            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },

                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.title.toString()
                    )
                },
                label = {
                    Text(text = stringResource(id = navItem.title))
                }
            )

        }
    }
}
@androidx.camera.core.ExperimentalGetImage
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PDM123Theme {
        MainScreen()
    }
}