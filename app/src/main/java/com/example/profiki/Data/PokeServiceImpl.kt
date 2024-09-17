package com.example.profiki.Data

class PokemonServiceImpl( private val pokemonApi: PokeApi) {
    suspend fun getPokemons():retrofit2.Response<PokemonItemsResponse> = pokemonApi.getPokemons()
    suspend fun getPokemon(name:String):retrofit2.Response<PokemonResponse> = pokemonApi.getPokemon(name)
    suspend fun getSpeciesByName(name: String):retrofit2.Response<SpeciesPokemonResponse> = pokemonApi.getSpeciesByName(name)

}