package com.example.profiki.Repository


import com.example.profiki.Data.PokemonResponse
import com.example.profiki.Data.PokemonServiceImpl
import com.example.profiki.Data.SpeciesPokemonResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepository(private val pokemonServiceImpl: PokemonServiceImpl) {
    fun getPokemons(): Flow<List<PokemonResponse>> = flow{
        val result = pokemonServiceImpl.getPokemons()
        val pokemonList = mutableListOf<PokemonResponse>()
        if (result.isSuccessful){
            val pokemonItems = checkNotNull(result.body())
            pokemonItems.results.forEach{
                val pokemonResponse =pokemonServiceImpl.getPokemon(it.name)
                if (pokemonResponse.isSuccessful){
                    val pokemon = checkNotNull(pokemonResponse.body())
                    pokemonList.add(pokemon)
                }
            }

        }
        emit(pokemonList)
    }
    fun getSpeciesByName(name:String):Flow<SpeciesPokemonResponse> = flow {
        val result=pokemonServiceImpl.getSpeciesByName(name)
        if (result.isSuccessful){
            val pokemonSpecies = checkNotNull(result.body())
            emit(pokemonSpecies)
        }
    }
}