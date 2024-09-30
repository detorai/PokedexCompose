package com.example.profiki

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profiki.Common.AppTopBar
import com.example.profiki.Common.PokemonsCard
import com.example.profiki.Data.PokeApiImpl
import com.example.profiki.Data.PokeService
import com.example.profiki.ui.UI.PokeViewModel

@SuppressLint("SuspiciousIndentation")
@Preview
@Composable
fun Pokedex(){
    val apiImpl = PokeApiImpl(PokeService.service)
    val viewModel = PokeViewModel(apiImpl)
    viewModel.getPokemons()
    val pokemons  = viewModel.pokemons.collectAsState()
        Scaffold(
            topBar = { AppTopBar() }
        ){ innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                PokemonsCard(pokemons.value)
            }
        }
}