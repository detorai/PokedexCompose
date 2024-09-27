package com.example.profiki.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profiki.Data.Model.Pokemons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokeViewModel: ViewModel(){
    private val _pokemons = MutableStateFlow<Pokemons?>(null)
    val pokemons: StateFlow<Pokemons?> = _pokemons.asStateFlow()

    fun getPokemons(){

        }
}