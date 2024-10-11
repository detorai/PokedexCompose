package com.example.profiki.Common

import androidx.compose.ui.graphics.Color
import com.example.profiki.Data.Model.PokemonResponse

fun colorName (
    pokemon: PokemonResponse?
): Any {
    return when (pokemon?.types?.){
        "bug" -> 0xFFA7B723
        "dark" -> 0xFF75574C
        "dragon" -> 0xFF7037FF
        "electric" -> 0xFFF9CF30
        "fairy" -> 0xFFE69EAC
        "fire" -> 0xFFF57D31
        "fighting" -> 0xFFC12239
        "flying" -> 0xFFA891EC
        "ghost" -> 0xFF70559B
        "grass" -> 0xFF74CB48
        "ground" -> 0xFFDEC16B
        "ice" -> 0xFF9AD6DF
        "normal" -> 0xFFAAA67F
        "poison" -> 0xFFA43E9E
        "psychic" -> 0xFFFB5584
        "rock" -> 0xFFB69E31
        "steel" -> 0xFFB7B9D0
        "water" -> 0xFF6493EB
        else -> Color.Cyan
    }
}