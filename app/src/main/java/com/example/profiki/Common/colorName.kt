package com.example.profiki.Common

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColor
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.TypesResponse

fun colorName (
    pokemon: PokemonResponse?
): Color {
    return when (pokemon?.types?.firstOrNull()?.type?.name){

        "bug" -> Color(0xFFA7B723)
        "dark" -> Color(0xFF75574C)
        "dragon" -> Color(0xFF7037FF)
        "electric" -> Color(0xFFF9CF30)
        "fairy" -> Color(0xFFE69EAC)
        "fire" -> Color(0xFFF57D31)
        "fighting" -> Color(0xFFC12239)
        "flying" -> Color(0xFFA891EC)
        "ghost" -> Color(0xFF70559B)
        "grass" -> Color(0xFF74CB48)
        "ground" -> Color(0xFFDEC16B)
        "ice" -> Color(0xFF9AD6DF)
        "normal" -> Color(0xFFAAA67F)
        "poison" -> Color(0xFFA43E9E)
        "psychic" -> Color(0xFFFB5584)
        "rock" -> Color(0xFFB69E31)
        "steel" -> Color(0xFFB7B9D0)
        "water" -> Color(0xFF6493EB)
        else -> Color.Cyan
    }
}

fun colorDopName (
    pokemon: PokemonResponse?
): Color {
    return when (pokemon?.types?.firstOrNull()?.type?.name){
        "bug" -> Color(0x33A7B723)
        "dark" -> Color(0x3375574C)
        "dragon" -> Color(0x337037FF)
        "electric" -> Color(0x33F9CF30)
        "fairy" -> Color(0x33E69EAC)
        "fire" -> Color(0x33F57D31)
        "fighting" -> Color(0x33C12239)
        "flying" -> Color(0x33A891EC)
        "ghost" -> Color(0x3370559B)
        "grass" -> Color(0x3374CB48)
        "ground" -> Color(0x33DEC16B)
        "ice" -> Color(0x339AD6DF)
        "normal" -> Color(0x33AAA67F)
        "poison" -> Color(0x33A43E9E)
        "psychic" -> Color(0x33FB5584)
        "rock" -> Color(0x33B69E31)
        "steel" -> Color(0x33B7B9D0)
        "water" -> Color(0x336493EB)
        else -> Color.Cyan
    }
}

fun colorType (
    type: TypesResponse?
): Color {
    return when (type?.type?.name){
        "bug" -> Color(0xFFA7B723)
        "dark" -> Color(0xFF75574C)
        "dragon" -> Color(0xFF7037FF)
        "electric" -> Color(0xFFF9CF30)
        "fairy" -> Color(0xFFE69EAC)
        "fire" -> Color(0xFFF57D31)
        "fighting" -> Color(0xFFC12239)
        "flying" -> Color(0xFFA891EC)
        "ghost" -> Color(0xFF70559B)
        "grass" -> Color(0xFF74CB48)
        "ground" -> Color(0xFFDEC16B)
        "ice" -> Color(0xFF9AD6DF)
        "normal" -> Color(0xFFAAA67F)
        "poison" -> Color(0xFFA43E9E)
        "psychic" -> Color(0xFFFB5584)
        "rock" -> Color(0xFFB69E31)
        "steel" -> Color(0xFFB7B9D0)
        "water" -> Color(0xFF6493EB)
        else -> Color.Cyan
    }
}