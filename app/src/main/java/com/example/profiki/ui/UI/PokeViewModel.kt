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

    private val _pokemon = MutableStateFlow<PokemonResponse?>(null)
    val pokemon: StateFlow<PokemonResponse?> = _pokemon.asStateFlow()

    var currentSortMode: StateSort = StateSort.NUMBER
    private val _pokemonList = MutableStateFlow<List<PokemonResponse>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()

    private val _pokemonSpecies = MutableStateFlow<SpeciesPokemonResponse?>(null)
    val pokemonSpecies = _pokemonSpecies.asStateFlow()

    private val _currentIndex = MutableStateFlow(0)



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


    //Получение описания

    fun getSpeciesByName(name: String) {
        viewModelScope.launch {
            try {
                val species = apiImpl.getSpeciesByName(name)
                if (species.isSuccessful) {
                    _pokemonSpecies.emit(species.body())
                }
            } catch (e: Exception) {
                println("Error getting pokemon-species: ${e.message}")
            }
        }
    }


    //Получение данных о конкретном покемоне

    private fun getPokemon(name: String) {
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

    fun getSpecificPokemon() {
        if (_currentIndex.value in _pokemonList.value.indices) {
            val pokemonName = _pokemonList.value[_currentIndex.value].name
            getPokemon(pokemonName)
            getSpeciesByName(pokemonName)
        } else {
            println("Некорректный индекс: ${_currentIndex.value}. Доступные индексы: 0 to ${_pokemonList.value.size - 1}")
        }
    }


    // Переключение между элементами списка

    fun nextPokemon() {
        val currentIdx = _currentIndex.value
        if (currentIdx < _pokemonList.value.size - 1) {
            _currentIndex.value = currentIdx + 1
        }
    }

    fun prevPokemon() {
        val currentIdx = _currentIndex.value
        if (currentIdx > 0) {
            _currentIndex.value = currentIdx - 1
        }
    }

    fun updateCurrentIndex(index: Int) {
        _currentIndex.value = index
    }
}



