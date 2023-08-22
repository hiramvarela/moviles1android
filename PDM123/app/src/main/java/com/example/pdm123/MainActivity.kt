package com.example.pdm123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pdm123.ui.theme.PDM123Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDM123Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                        MainScreen()
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "ulsa chihuahua") })},
        content = { it
            NavigationHost(navController = navController)
        },
        bottomBar = {BottomNavigationBar(navController = navController)}
    )

}

/**
 * Esta funcion va a ser encargada de manejar los tabs de la aplicacion
 */
@Composable
fun NavigationHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = NavRoutes.firstPartial.route){
        composable(NavRoutes.firstPartial.route){
            FirstPartial()
        }
        composable(NavRoutes.secondPartial.route){
            SecondPartial()
        }
        composable(NavRoutes.thirdPartial.route){
            ThirdPartial()
        }
    }
}
@Composable
fun BottomNavigationBar(navController: NavHostController){

    BottomNavigation{
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.NavBarItems.forEach{navItem ->

            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }
            )

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    PDM123Theme {
//        MainScreen()
//    }
//}