package com.example.profiki.ui.UI.Pokemons.PokemonsComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.Data.Model.PokemonResponse

@Composable
fun StatValue(stateValue: PokemonResponse?,modifier: Modifier, color: Color, colorDop: Color ) {

    LazyColumn (
        modifier = modifier.padding(0.dp, 0.dp, 16.dp, 0.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        if (stateValue != null) {
            itemsIndexed(stateValue.stats){index, stats ->
                Text(stats.base_stat.toString(),
                    fontSize = 15.sp)
            }
        }
    }
    LazyColumn (
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        if (stateValue != null) {
            itemsIndexed(stateValue.stats){index, stats ->
                LinearProgressIndicator(
                    progress = { stats.base_stat.toFloat()/100 },
                    color = color,
                    trackColor = colorDop
                )
            }
        }
    }
}