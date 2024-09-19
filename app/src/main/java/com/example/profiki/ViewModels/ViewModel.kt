package com.example.profiki.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.profiki.Data.PokemonResponse
import com.example.profiki.PokemonApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainScreenViewModel(application: Application): AndroidViewModel(application  ) {
    private val repository by lazy { (application as PokemonApplication).repository }
    private val _stateMainScreen = MutableStateFlow(MainScreenState())
    val stateMainScreen = _stateMainScreen.asStateFlow()
    private val _stateAboutScreen = MutableStateFlow(AboutScreenState())
    val stateAboutScreen = _stateAboutScreen.asStateFlow()

    fun selectPokemon(pokemonResponse: PokemonResponse){
        val pokemonSpecies = repository.getSpeciesByName(pokemonResponse.name)
        viewModelScope.launch {
            pokemonSpecies.collect{resp ->
                _stateAboutScreen.update { it.copy(color = resp.color.name,pokemonResponse=pokemonResponse) }
            }
        }
    }
    fun getPokemons(){
        _stateMainScreen.update { it.copy(isLoading = true) }
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPokemons().collect { result ->
                _stateMainScreen.update {
                    it.copy(
                        isLoading = false,
                        pokemonList = result
                    )
                }
            }
        }
    }
}