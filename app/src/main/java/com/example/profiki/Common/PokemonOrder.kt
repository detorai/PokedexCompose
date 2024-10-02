package com.example.profiki.Common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.profiki.Data.Model.PokemonItem
import com.example.profiki.Data.Model.PokemonResponse

@Composable
fun pokemonNameToNumber (pokemon: PokemonResponse?, pokemons: PokemonItem?): Int? {
    if (pokemons?.name == pokemon?.name) {
        return pokemon?.order
    } else {
        return null
    }
}