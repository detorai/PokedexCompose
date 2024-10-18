package com.example.profiki.ui.UI.Pokedex

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.profiki.ui.UI.Pokemons.PokemonsScreen
import org.koin.androidx.compose.getViewModel

class PokedexScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    override fun Content() {
        val viewModel: PokeViewModel = getViewModel()
        val navigator = LocalNavigator.current
        LaunchedEffect(Unit) {
            viewModel.getPokemons()
        }
        val searchText by viewModel.searchText.collectAsState()
        val pokemonsAbout = viewModel.mainScreenState.collectAsState().value.pokemonList
        Pokedex(
            pokemons = pokemonsAbout,
            onClickPokemon = {index ->
                navigator?.push(PokemonsScreen(index, pokemonsAbout))},
            onSortModeChange = viewModel::updateSortMode,
            searchText = searchText,
            onClearSearch =  {},
            onSearchTextChange = viewModel::onValueChange
        )
    }
}