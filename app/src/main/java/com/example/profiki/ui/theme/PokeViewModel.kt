package com.example.profiki.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profiki.Data.Model.Pokemons
import com.example.profiki.Data.PokeApiImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokeViewModel(val apiImpl: PokeApiImpl): ViewModel(){
    private val _pokemons = MutableStateFlow<List<Pokemons>>(emptyList())
    val pokemons: StateFlow<List<Pokemons>> = _pokemons.asStateFlow()



    fun getPokemons(){
        viewModelScope.launch {
           apiImpl.getPokemons().collect {
               _pokemons.emit(it.results)
           }
        }
        }
}