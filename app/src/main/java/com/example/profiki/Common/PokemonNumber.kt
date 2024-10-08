

package com.example.profiki.Common

import com.example.profiki.Data.Model.PokemonResponse

fun pokemonNumber(index: Int): String {
    val pokemonNumber = index.toString()
    return when (pokemonNumber.length){
        1 -> "#00$pokemonNumber"
        2 -> "#0$pokemonNumber"
        3 -> "#$pokemonNumber"
        else -> throw
        IllegalArgumentException("Length should be 1 to 3")
    }
}