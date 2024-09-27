package com.example.profiki.Data

class PokeApiImpl(private val pokeApi: PokeApi) {
    suspend fun getPokemons() = pokeApi.getPokemons()
}