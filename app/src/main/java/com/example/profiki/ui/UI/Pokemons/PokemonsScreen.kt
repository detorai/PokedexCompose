package com.example.profiki.ui.UI.Pokemons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.profiki.Data.Model.PokemonResponse
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

class PokemonsScreen(private val index: Int, private val pokemonList: List<PokemonResponse>):
    Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {

        val viewModel: PokeAboutViewModel = getViewModel { parametersOf(pokemonList)}
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
