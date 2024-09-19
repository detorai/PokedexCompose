package com.example.profiki.ViewModels

import com.example.profiki.Data.PokemonResponse

data class AboutScreenState(
    var color:String="White",
    var pokemonResponse: PokemonResponse? = null
)