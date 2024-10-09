package com.example.profiki.Data

import com.example.profiki.Data.Model.PokemonItemsResponse
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.SpeciesPokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    @GET("api/v2/pokemon/")
    suspend fun getPokemons(): Response<PokemonItemsResponse>

    @GET ("api/v2/pokemon/{name}")
    suspend fun getPokemon(@Path("name")name: String): Response<PokemonResponse>

    @GET ("api/v2/pokemon-species/{name}")
    suspend fun getSpeciesByName(@Path("name")name: String): Response<SpeciesPokemonResponse>
}