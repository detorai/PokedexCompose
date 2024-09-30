package com.example.profiki.Data.Model


data class PokemonItem(
    val name: String,
    val url: String
)

data class PokemonItemsResponse(
    val results: List<PokemonItem>
)