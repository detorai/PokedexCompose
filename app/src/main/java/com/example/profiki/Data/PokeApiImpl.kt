package com.example.profiki.Data

import com.example.profiki.Data.Model.PokemonItemsResponse
import com.example.profiki.Data.Model.PokemonResponse
import kotlinx.coroutines.flow.flow

class PokeApiImpl(private val pokeApi: PokeApi) {
    fun getPokemons() = flow<PokemonItemsResponse> {
        emit(pokeApi.getPokemons())
    }
    fun getPokemon(name: String) = flow<PokemonResponse> {
        emit(pokeApi.getPokemon(name))
    }
}