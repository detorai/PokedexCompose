package com.example.profiki.Common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.profiki.Data.Model.PokemonResponse
import java.util.Locale

@Composable
fun Abilities(ability: PokemonResponse?){
    LazyVerticalGrid(
        columns = GridCells.Fixed(1)
    ) {
        if (ability != null) {
            itemsIndexed(ability.abilities){ index, ability ->
                Text(ability.ability.name.capitalize(Locale.ROOT),
                    fontSize = 15.sp)
            }
        }
    }
}