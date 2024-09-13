package com.example.profiki.Ul.Screens

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.profiki.Pokedex
import com.example.profiki.Pokemons

object HomeScreen: Screen{
    private fun readResolve(): Any = HomeScreen


    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Pokedex { navigator?.push(CardScreen) }
    }
}
object CardScreen: Screen{
    private fun readResolve(): Any = CardScreen


    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Pokemons { navigator?.pop() }
    }
}
