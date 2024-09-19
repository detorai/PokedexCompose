package com.example.profiki.ViewModels

import com.example.profiki.Data.PokemonResponse

data class MainScreenState(
    var isNumberSorted:Boolean= true,
    var isNameSorted:Boolean = false,
    val isLoading:Boolean = false,
    val isError:Boolean=false,
    val searchText:String = "",
    val pokemonList:List<PokemonResponse> = emptyList()
)