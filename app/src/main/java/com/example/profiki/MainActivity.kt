package com.example.profiki

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import com.example.profiki.Data.PokeApi
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.Data.PokeService
import com.example.profiki.ui.UI.PokeViewModel

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val apiImpl = PokeApiImpl(PokeService.service)
            val viewModel = PokeViewModel(apiImpl)
            viewModel.getPokemon("bulbasaur")
            val pokemon = viewModel.pokemon.collectAsState()
            Pokemons(pokemon.value)
        }
    }
}



