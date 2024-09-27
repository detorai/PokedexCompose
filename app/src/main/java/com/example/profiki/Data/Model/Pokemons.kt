package com.example.profiki.Data.Model


data class Pokemons(
    val name: String,
    val url: String
)

data class PokemonResponse(
    val results: List<Pokemons>
)