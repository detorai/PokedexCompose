package com.example.profiki.Data


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("api/v2/pokemon/")
    suspend fun getPokemons(): Response<PokemonItemsResponse>
    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemon(@Path("name")name:String):Response<PokemonResponse>
    @GET("api/v2/pokemon-species/{name}")
    suspend fun getSpeciesByName(@Path("name")name:String):Response<SpeciesPokemonResponse>
}