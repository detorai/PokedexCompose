package com.example.profiki

import android.app.Application
import com.example.profiki.Data.PokeService
import com.example.profiki.Data.PokemonServiceImpl
import com.example.profiki.Repository.PokemonRepository

class PokemonApplication: Application() {
    private val pokemonServiceImpl = PokemonServiceImpl(PokeService.getService())
    val repository = PokemonRepository(pokemonServiceImpl)

}