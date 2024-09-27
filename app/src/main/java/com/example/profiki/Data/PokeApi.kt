package com.example.profiki.Data

import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.Pokemons
import kotlinx.coroutines.flow.Flow
import okhttp3.Response
import retrofit2.http.GET

interface PokeApi {
    @GET("api/v2/pokemon/")
    suspend  fun getPokemons(): PokemonResponse
}