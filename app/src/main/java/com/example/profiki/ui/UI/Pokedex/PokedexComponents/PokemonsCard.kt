package com.example.profiki.ui.UI.Pokedex.PokedexComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.Common.loadImage
import com.example.profiki.Common.pokemonNumber
import com.example.profiki.Data.Model.PokemonResponse
import java.util.Locale


@Composable
fun PokemonsCard(
    pokemons: List<PokemonResponse>,
    onClickPokemon: (Int)-> Unit,
    searchText: String) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Red)
            .padding(6.dp, 6.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(8.dp, 24.dp),
            horizontalArrangement = Arrangement.Center


        ) {
            itemsIndexed(
                pokemons.filter { pokemon ->
                    pokemon.name.contains(
                        searchText, ignoreCase = true)
                            ||
                    pokemon.order.toString().contains(searchText)
                }
            ) { index, pokemon ->
                val imageBitmap = loadImage(pokemon.sprites.other.official_artwork.front_default)
                Card(
                    onClick = {onClickPokemon(index)},
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(104.dp, 108.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = pokemonNumber(pokemon.order),
                            color = Color.Gray,
                            fontSize = 8.sp,
                            modifier = Modifier
                                .padding(0.dp, 4.dp, 8.dp, 0.dp)
                                .align(Alignment.TopEnd)
                        )

                        Card(
                            shape = RoundedCornerShape(7.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFEFEFEF)
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.4f)
                                .align(Alignment.BottomCenter),


                            ) {
                            Row(
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            ) {
                                Text(
                                    text = pokemon.name.capitalize(Locale.ROOT),
                                    color = Color.Black,
                                    fontSize = 10.sp,
                                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 4.dp),

                                    )
                            }
                        }
                        Image(
                            modifier = Modifier.align(Alignment.Center).size(72.dp,72.dp),
                            bitmap = imageBitmap,
                            contentDescription = "Pokemon",
                            alignment = Alignment.Center


                        )
                    }
                }
            }
        }
    }
}

