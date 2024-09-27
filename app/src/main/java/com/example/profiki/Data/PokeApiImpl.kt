package com.example.profiki.Data

import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.Pokemons
import kotlinx.coroutines.flow.flow

class PokeApiImpl(private val pokeApi: PokeApi) {
    fun getPokemons() = flow<PokemonResponse> {
        emit(pokeApi.getPokemons())
    }
}