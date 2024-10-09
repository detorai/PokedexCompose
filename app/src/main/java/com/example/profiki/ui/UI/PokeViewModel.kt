package com.example.profiki.ui.UI

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profiki.Data.Model.MainScreenState
import com.example.profiki.Data.Model.PokemonItem
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.StateSort
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.PokeApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class PokeViewModel(val apiImpl: PokeApiImpl, application: PokeApplication): AndroidViewModel(application) {

    private val repository by lazy { (application).repository }

    private val _mainScreenState = MutableStateFlow(MainScreenState())
    val mainScreenState = _mainScreenState.asStateFlow()

    private val _pokemon = MutableStateFlow<PokemonResponse?>(null)
    val pokemon: StateFlow<PokemonResponse?> = _pokemon.asStateFlow()


    fun getPokemon(name: String) {
        viewModelScope.launch {
            try {
                val response = apiImpl.getPokemon(name)
                if (response.isSuccessful) {
                    _pokemon.emit(response.body())
                }
            } catch (e: Exception) {
                println("Error getting pokemon: ${e.message}")
            }
        }
    }


    fun getPokemons() {
        _mainScreenState.update { it }
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPokemonsList().collect { result ->
                _mainScreenState.update { it.copy(
                    pokemonList = result
                ) }
            }
        }
    }
}


