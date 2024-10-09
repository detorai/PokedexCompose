package com.example.profiki

import android.app.Application
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.Data.PokeService
import com.example.profiki.Data.Repository.PokeRepository

class PokeApplication:Application() {
    private val pokeImpl = PokeApiImpl(PokeService.service)
    val repository = PokeRepository(pokeImpl)
}