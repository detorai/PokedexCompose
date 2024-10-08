package com.example.profiki.Ul.Common

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.R


@Composable
fun PokemonsCard(onClickPokemon: ()-> Unit) {
    val pokemonNumber by remember { mutableStateOf("999") }
    val pokemonName by remember { mutableStateOf("Pokemon Name")}
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Red)
            .padding(6.dp,6.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(8.dp,24.dp),
            horizontalArrangement = Arrangement.Center


        ){
            items (
                count = 12,

                ) {
                Card (
                    onClick = onClickPokemon,
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier.padding(8.dp)
                        .size(104.dp,108.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ){
                    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()){
                        Text(
                            pokemonNumber,
                            color = Color.Gray,
                            fontSize = 8.sp,
                            modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 18.dp).align(Alignment.TopEnd)
                        )

                        Card(
                            shape = RoundedCornerShape(7.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.LightGray
                            ),
                            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.4f).align(Alignment.BottomCenter),


                            ){
                            Row(verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.fillMaxWidth()
                                    .fillMaxHeight()
                            ) {
                                Text(
                                    pokemonName,
                                    color = Color.Black,
                                    fontSize = 10.sp,

                                    )
                            }
                        }
                        Image(
                            modifier = Modifier.align(Alignment.Center),
                            imageVector = ImageVector.vectorResource(R.drawable.image),
                            contentDescription = "Pokemon",
                            alignment = Alignment.Center



                        )
                    }
                }
            }
        }
    }
}