package com.example.profiki

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Composable
fun Main(){
    val navController = rememberNavController()
    CustomNavController(navController = navController)

}
@Composable
fun CustomNavController(navController: NavHostController){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.Pokedex.route){
        composable(NavRoutes.Pokedex.route){
            Pokedex()
        }
        composable(NavRoutes.Pokemons.route){
            Pokemons()
        }
    }
}

sealed class NavRoutes(val route: String) {
    object Pokedex : NavRoutes("pokedex")
    object Pokemons : NavRoutes("pokemons")

}


