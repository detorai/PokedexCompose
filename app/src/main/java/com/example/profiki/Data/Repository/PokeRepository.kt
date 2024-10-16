package com.example.profiki.Data.Repository

import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.PokeApiImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokeRepository(private val apiImpl: PokeApiImpl) {
    fun getPokemonsList(): Flow<List<PokemonResponse>> = flow {
        val result = apiImpl.getPokemons()
        val pokemonList = mutableListOf<PokemonResponse>()
        if (result.isSuccessful) {
            val pokemonItems = checkNotNull(result.body())
            pokemonItems.results.forEach {
                val pokemonResponse = apiImpl.getPokemon(it.name)
                if (pokemonResponse.isSuccessful) {
                    val pokemon = checkNotNull(pokemonResponse.body())
                    pokemonList.add(pokemon)
                }
            }
        }
        emit(pokemonList)
    }
}

