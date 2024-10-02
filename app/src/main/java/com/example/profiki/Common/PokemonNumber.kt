@file:Suppress("NAME_SHADOWING")

package com.example.profiki.Common

import com.example.profiki.Data.Model.PokemonResponse

fun pokemonNumber(pokemonOrder: String, pokemon: PokemonResponse?): String {
    val pokemonOrder = pokemon?.order.toString()
    return when (pokemonOrder.length){
        1 -> "00$pokemonOrder"
        2 -> "0$pokemonOrder"
        3 -> pokemonOrder
        else -> throw
        IllegalArgumentException("Length should be 1 to 3")
    }
}