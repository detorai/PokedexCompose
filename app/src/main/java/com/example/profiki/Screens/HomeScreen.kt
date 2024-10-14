package com.example.profiki.Screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.profiki.Data.Model.StateSort
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.Data.PokeService
import com.example.profiki.PokeApplication
import com.example.profiki.ui.UI.Pokedex
import com.example.profiki.ui.UI.Pokemons
import com.example.profiki.ui.UI.PokeViewModel


class HomeScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    private val apiImpl = PokeApiImpl(PokeService.service)
    private val viewModel = PokeViewModel(apiImpl, PokeApplication())



    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        viewModel.getPokemons()
        val searchText by viewModel.searchText.collectAsState()
        val pokemonsAbout = viewModel.mainScreenState.collectAsState().value.pokemonList
        Pokedex(
            pokemons = pokemonsAbout,
            onClickPokemon = {name -> navigator?.push(PokemonScreen(name))},
            sortMode = viewModel.currentSortMode,
            onSortModeChange = viewModel::updateSortMode,
            searchText = searchText,
            onClearSearch =  {},
            onSearchTextChange = viewModel::onValueChange
            )
    }
}
class PokemonScreen(val name: String): Screen {

    override val key: ScreenKey = uniqueScreenKey

    private val apiImpl = PokeApiImpl(PokeService.service)
    private val viewModel = PokeViewModel(apiImpl, PokeApplication())

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        viewModel.getPokemon(name)
        viewModel.getSpeciesByName(name)
        val pokemon = viewModel.pokemon.collectAsState().value
        val species = viewModel.pokemonSpecies.collectAsState().value
        Pokemons(
            pokemon = pokemon,
            onClickBack = { navigator?.pop() },
            species = species
        )
    }
}