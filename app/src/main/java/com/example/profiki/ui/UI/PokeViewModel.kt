package com.example.profiki.ui.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profiki.Data.Model.PokemonItem
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.PokeApiImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokeViewModel(val apiImpl: PokeApiImpl): ViewModel(){
    private val _pokemons = MutableStateFlow<List<PokemonItem>>(emptyList())
    val pokemons: StateFlow<List<PokemonItem>> = _pokemons.asStateFlow()
    private val _pokemon = MutableStateFlow<PokemonResponse?>(null)
    val pokemon: StateFlow<PokemonResponse?> = _pokemon.asStateFlow()


    fun getPokemon(name: String){
        viewModelScope.launch {
            apiImpl.getPokemon(name = name).collect{
                _pokemon.emit(it.copy())
            }
        }
    }

    fun getPokemons(){
        viewModelScope.launch {
           apiImpl.getPokemons().collect {
               _pokemons.emit(it.results)
           }
        }
    }
}