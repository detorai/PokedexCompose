package com.example.profiki.ui.UI

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profiki.Data.Model.MainScreenState
import com.example.profiki.Data.Model.PokemonItem
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.SpeciesPokemonResponse
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

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _mainScreenState = MutableStateFlow(MainScreenState())
    val mainScreenState = _mainScreenState.asStateFlow()

    var currentSortMode: StateSort = StateSort.NUMBER

    private val _pokemonList = MutableStateFlow<List<PokemonResponse>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()




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



