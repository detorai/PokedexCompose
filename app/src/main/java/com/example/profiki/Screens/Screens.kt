package com.example.profiki.Screens

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.Data.PokeService
import com.example.profiki.Pokedex
import com.example.profiki.Pokemons
import com.example.profiki.ui.UI.PokeViewModel

object HomeScreen: Screen {
    private fun readResolve(): Any = HomeScreen


    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Pokedex { navigator?.push(CardScreen) }
    }
}
object CardScreen: Screen{
    private fun readResolve(): Any = CardScreen


    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val apiImpl = PokeApiImpl(PokeService.service)
        val viewModel = rememberScreenModel{ PokeViewModel(apiImpl)}
        viewModel.getPokemon("bulbasaur")
        val pokemon = viewModel.pokemon.collectAsState()
        Pokemons(
            pokemon = pokemon.value,
            onClickBack = { navigator?.pop() }
        )
    }
}