@file:Suppress("UNUSED_EXPRESSION")

package com.example.profiki.ui.UI

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profiki.Common.AppTopBar
import com.example.profiki.Common.PokemonsCard
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.StateSort

@SuppressLint("SuspiciousIndentation", "StateFlowValueCalledInComposition")
@Composable
fun Pokedex(pokemons: List<PokemonResponse>, sortMode: StateSort, onClickPokemon: (String) -> Unit){
    val sortedList = when (sortMode) {
        StateSort.NUMBER -> pokemons.sortedBy { it.order }
        StateSort.NAME -> pokemons.sortedBy { it.name }
    }
    Scaffold(
            topBar = { AppTopBar{newSortMode -> onSortModeChange(newSortMode)}}
        ){ innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                PokemonsCard(
                    onClickPokemon = onClickPokemon,
                    pokemons = sortedList
                    )
            }
        }
}
fun onSortModeChange(newSortMode: StateSort) {
    onSortModeChange = {newSortMode}
}
private var onSortModeChange: (StateSort) -> Unit = {}

