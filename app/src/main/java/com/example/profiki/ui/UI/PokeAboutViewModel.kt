package com.example.profiki.ui.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.SpeciesPokemonResponse
import com.example.profiki.Data.PokeApiImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokeAboutViewModel(val apiImpl: PokeApiImpl, private val pokemonList: List<PokemonResponse>): ViewModel() {

    private val _pokemon = MutableStateFlow<PokemonResponse?>(null)
    val pokemon: StateFlow<PokemonResponse?> = _pokemon.asStateFlow()

    private val _pokemonSpecies = MutableStateFlow<SpeciesPokemonResponse?>(null)
    val pokemonSpecies = _pokemonSpecies.asStateFlow()

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex = _currentIndex.asStateFlow()

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
        viewModelScope.launch {
            if (_currentIndex.value in pokemonList.indices) {
                val pokemonName = pokemonList[_currentIndex.value].name
                getPokemon(pokemonName)
                getSpeciesByName(pokemonName)
            } else {
                println("Некорректный индекс: ${_currentIndex.value}. Доступные индексы: 0 to ${pokemonList.size - 1}")
            }
        }
    }


    // Переключение между элементами списка

    fun nextPokemon() {
        val currentIdx = _currentIndex.value
        if (currentIdx < pokemonList.size - 1) {
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