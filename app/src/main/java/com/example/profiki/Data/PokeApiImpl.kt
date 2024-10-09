package com.example.profiki.Data

import com.example.profiki.Data.Model.PokemonItemsResponse
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.SpeciesPokemonResponse
import kotlinx.coroutines.flow.flow

class PokeApiImpl(private val pokeApi: PokeApi) {
    suspend fun getPokemons():retrofit2.Response<PokemonItemsResponse> =pokeApi.getPokemons()
    suspend fun getPokemon(name:String):retrofit2.Response<PokemonResponse> = pokeApi.getPokemon(name)
    suspend fun getSpeciesByName(name: String):retrofit2.Response<SpeciesPokemonResponse> = pokeApi.getSpeciesByName(name)
    /*fun getPokemons() = flow<PokemonItemsResponse> {
        emit(pokeApi.getPokemons())
    }
    fun getPokemon(name: String) = flow<PokemonResponse> {
        emit(pokeApi.getPokemon(name))
    }
    fun getSpeciesByName(name:String) = flow<SpeciesPokemonResponse> {
        emit(pokeApi.getSpeciesByName(name))
    }*/
}