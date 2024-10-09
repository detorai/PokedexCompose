

package com.example.profiki.Common

import com.example.profiki.Data.Model.PokemonResponse

fun pokemonNumber(order: Int): String {
    val pokemonNumber = order.toString()
    return when (pokemonNumber.length){
        1 -> "#00$pokemonNumber"
        2 -> "#0$pokemonNumber"
        3 -> "#$pokemonNumber"
        else -> throw
        IllegalArgumentException("Length should be 1 to 3")
    }
}