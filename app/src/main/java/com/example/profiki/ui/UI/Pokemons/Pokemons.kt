package com.example.profiki.ui.UI.Pokemons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.profiki.ui.UI.Pokemons.PokemonsComponents.PokemonAboutCard
import com.example.profiki.ui.UI.Pokemons.PokemonsComponents.TopNameRow
import com.example.profiki.ui.UI.Pokemons.PokemonsComponents.TypeRow
import com.example.profiki.Common.colorDopName
import com.example.profiki.Common.colorName
import com.example.profiki.Common.loadImage
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.SpeciesPokemonResponse
import com.example.profiki.R


@Composable
fun Pokemons(
    pokemon: PokemonResponse?,
    species: SpeciesPokemonResponse?,
    currentIndex: Int,
    pokemonList: List<PokemonResponse>,
    onClickBack: () -> Unit,
    onClickPrev: () -> Unit,
    onClickNext: () -> Unit){

    Box(
        modifier = Modifier
            .background(color = colorName(pokemon))
            .fillMaxHeight()
            .fillMaxWidth()
    ){
        Image(imageVector = ImageVector.vectorResource(R.drawable.pokeball),
            contentDescription = "pokeball",
            colorFilter = ColorFilter.tint(color = colorDopName(pokemon)),
            modifier = Modifier
                .size(246.dp, 248.dp)
                .padding(0.dp, 8.dp, 9.dp, 0.dp)
                .align(Alignment.TopEnd),
            )

        //TopNameRow
        TopNameRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp, 20.dp)
                .align(Alignment.TopCenter),
            onClickBack = onClickBack,
            pokemon = pokemon

        )

       //PokemonAboutCard

       PokemonAboutCard(
           modifier = Modifier
           .fillMaxWidth()
           .fillMaxHeight(0.7f)
           .align(Alignment.BottomCenter)
           .padding(4.dp),
           pokemon = pokemon,
           species = species
       )

        //PokemonImage

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ){
        Image(
            bitmap = loadImage(pokemon?.sprites?.other?.official_artwork?.front_default.toString()),
            contentDescription = "PokemonImage",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(0.dp, 100.dp, 0.dp, 0.dp)
                .size(230.dp, 230.dp)
        )

        //Type Row
        TypeRow(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 100.dp)
                    .align(Alignment.BottomCenter),
            pokemon = pokemon
        )
        Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(18.dp, 0.dp)
            ) {
                Column {
                    if (currentIndex > 0) {
                        IconButton(
                            onClick = onClickPrev,
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
                Column {
                    if (currentIndex < pokemonList.size - 1) {
                        IconButton(
                            onClick = onClickNext,
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Next",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}




