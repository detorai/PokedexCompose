

package com.example.profiki.Common

fun pokemonNumber(order: Int?): String {
    if (order == null) {
        return "#000"
    }
    val pokemonNumber = order.toString()
    return when (pokemonNumber.length) {
        1 -> "#00$pokemonNumber"
        2 -> "#0$pokemonNumber"
        3 -> "#$pokemonNumber"
        else -> throw IllegalArgumentException("Length should be 1 to 3")
    }
}