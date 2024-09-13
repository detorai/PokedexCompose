package com.example.profiki

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profiki.Ul.Common.AppTopBar
import com.example.profiki.Ul.Common.PokemonsCard


@Composable
fun Pokedex(onClickPokemon: ()-> Unit){
        Scaffold(
            topBar = { AppTopBar() }
        ){ innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                PokemonsCard(onClickPokemon = onClickPokemon)
            }
        }
}