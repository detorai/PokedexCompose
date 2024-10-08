package com.example.profiki.Screens

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.Data.PokeService
import com.example.profiki.ui.UI.Pokedex
import com.example.profiki.ui.UI.Pokemons
import com.example.profiki.ui.UI.PokeViewModel


object HomeScreen: Screen {
    private fun readResolve(): Any = HomeScreen

    private val apiImpl = PokeApiImpl(PokeService.service)
    private val viewModel = PokeViewModel(apiImpl)

    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        viewModel.getPokemons()
        val pokemons = viewModel.pokemons.collectAsState().value
        Pokedex(
            pokemons = pokemons,
            onClickPokemon = {name -> navigator?.push(PokemonScreen(name))})
    }
}
class PokemonScreen(val name: String): Screen {

    override val key: ScreenKey = uniqueScreenKey

    private val apiImpl = PokeApiImpl(PokeService.service)
    private val viewModel = PokeViewModel(apiImpl)

    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        viewModel.getPokemon(name)
        val pokemon = viewModel.pokemon.collectAsState().value
        Pokemons(
            pokemon = pokemon,
            onClickBack = { navigator?.pop() }
        )
    }
}
