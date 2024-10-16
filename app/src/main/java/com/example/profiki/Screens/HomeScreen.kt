package com.example.profiki.Screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.StateSort
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.Data.PokeService
import com.example.profiki.PokeApplication
import com.example.profiki.ui.UI.PokeAboutViewModel
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
        LaunchedEffect(Unit) {
            viewModel.getPokemons()
        }
        val searchText by viewModel.searchText.collectAsState()
        val pokemonsAbout = viewModel.mainScreenState.collectAsState().value.pokemonList
        Pokedex(
            pokemons = pokemonsAbout,
            onClickPokemon = {index ->
                navigator?.push(PokemonScreen(index, pokemonsAbout))},
            sortMode = viewModel.currentSortMode,
            onSortModeChange = viewModel::updateSortMode,
            searchText = searchText,
            onClearSearch =  {},
            onSearchTextChange = viewModel::onValueChange
            )
    }
}

class PokemonScreen(private val index: Int, private val pokemonList: List<PokemonResponse>): Screen {

    override val key: ScreenKey = uniqueScreenKey

    private val apiImpl = PokeApiImpl(PokeService.service)
    private val viewModel = PokeAboutViewModel(apiImpl, pokemonList)

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val pokemon = viewModel.pokemon.collectAsState().value
        val species = viewModel.pokemonSpecies.collectAsState().value
        val currentIndex = viewModel.currentIndex.collectAsState().value


        LaunchedEffect(index) {
            viewModel.updateCurrentIndex(index)
            viewModel.getSpecificPokemon()
        }
        Pokemons(
            pokemon = pokemon,
            onClickBack = { navigator?.pop() },
            onClickPrev = {
                viewModel.prevPokemon()
                viewModel.getSpecificPokemon()
                          },
            onClickNext = {
                viewModel.nextPokemon()
                viewModel.getSpecificPokemon()
                          },
            species = species,
            currentIndex = currentIndex,
            pokemonList = pokemonList
        )
    }
}
