package com.example.profiki.ui.UI.Pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profiki.Data.Model.MainScreenState
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.StateSort
import com.example.profiki.Data.Repository.PokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class PokeViewModel( private val repository: PokeRepository): ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _mainScreenState = MutableStateFlow(MainScreenState())
    val mainScreenState = _mainScreenState.asStateFlow()

    var currentSortMode: StateSort = StateSort.NUMBER

    private val _pokemonList = MutableStateFlow<List<PokemonResponse>>(emptyList())


    //Сортировка

    fun getPokemons() {
        if (_pokemonList.value.isEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.getPokemonsList().collect { result ->
                    _pokemonList.value = result
                    updateSortedPokemonList(currentSortMode)
                }
            }
        } else {
            updateSortedPokemonList(currentSortMode)
        }
    }

    fun onValueChange(text: String) {
        _searchText.value = text
    }


    fun updateSortMode(newSortMode: StateSort) {
        currentSortMode = newSortMode
        updateSortedPokemonList(newSortMode)
    }

    private fun updateSortedPokemonList(sortMode: StateSort) {
        val sortedList = when (sortMode) {
            StateSort.NUMBER -> _pokemonList.value.sortedBy { it.order }
            StateSort.NAME -> _pokemonList.value.sortedBy { it.name }
        }
        _mainScreenState.update { it.copy(pokemonList = sortedList) }
    }
}



