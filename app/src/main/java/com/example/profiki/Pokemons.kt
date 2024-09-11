package com.example.profiki

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Pokemons(){
    Box(
        modifier = Modifier.background(Color(184,184,184))
            .fillMaxHeight()
            .fillMaxWidth()
    ){
        Image(imageVector = ImageVector.vectorResource(R.drawable.pokeball),
            contentDescription = "pokeball",
            colorFilter = ColorFilter.tint(color = Color.LightGray),
            modifier = Modifier.size(246.dp,248.dp).padding(0.dp,8.dp, 9.dp, 0.dp).align(Alignment.TopEnd),
            )

        //TopNameRow
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(4.dp,20.dp).align(Alignment.TopCenter)
        ) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Search Icon",
                tint = Color.White,
                )
            Text("Pokémon Name",
                color = Color.White,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold,
                )
            Text("#999",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold)
        }
        Card (
            colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(Alignment.BottomCenter)
                .padding(4.dp),

        ) {
            //Type Row
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp,56.dp,20.dp,16.dp)
            ){
                    Text("Type",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp,0.dp)
                            .background(
                            Color.DarkGray,
                            shape = RoundedCornerShape(18.dp)
                        ).padding(8.dp, 2.dp)
                    )

                    Text("Type",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp,0.dp)
                            .background(
                            Color.DarkGray,
                            shape = RoundedCornerShape(18.dp)
                        ).padding(8.dp, 4.dp)

                    )
            }

            //Text Row
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(20.dp,16.dp,20.dp,0.dp)
            ) {
                Text("About",
                    color = Color.Gray,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                    )
            }

            //Characteristics Row
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(20.dp,16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.2f)
                        .fillMaxHeight(0.1f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.weight),
                            contentDescription = "weight",
                            modifier = Modifier.size(16.dp,17.dp)
                        )
                        Text("9,9 kg",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(4.dp,0.dp)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Text(
                            "Weight",
                            fontSize = 13.sp,
                        )
                    }
                }
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.divider),
                    contentDescription = "divider"
                )
                Column(
                    modifier = Modifier.fillMaxWidth(0.25f)
                        .fillMaxHeight(0.1f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row (
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Bottom,
                    ){
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.straighten),
                            contentDescription = "straighten",
                            modifier = Modifier.size(16.dp,17.dp)
                        )
                        Text("9,9m",
                            fontSize = 15.sp,
                            modifier = Modifier.padding(4.dp,0.dp)
                        )

                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.Bottom

                        ) {
                        Text(
                            "Height",
                            fontSize = 13.sp
                        )
                    }
                }
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.divider),
                    contentDescription = "divider",

                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth(0.3f)
                        .fillMaxHeight(0.15f)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,

                    ) {
                        Text(
                            "Ability 1",
                            fontSize = 15.sp
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                    ) {
                    Text("Ability 2",
                        fontSize = 15.sp
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            "Moves",
                            fontSize = 13.sp
                        )
                    }
                }
            }
            //About Row
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(20.dp,16.dp)
            ) {
                Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc iaculis eros vitae tellus condimentum maximus sit amet in eros.",
                    fontSize = 15.sp)
            }

            //Text 2 Row
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(20.dp,16.dp)
            ) {
                Text("Base Stats",
                    color = Color.Gray,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                    )
            }

            //Base Stats Row
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f).padding(0.dp,16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxHeight()

                ) {
                    Text("HP",
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text("ATK",
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text("DEF",
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text("SATK",
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text("SDEF",
                        color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text("SPD", color = Color.Gray,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.divider),
                    contentDescription = "divider",
                    modifier = Modifier.fillMaxHeight().size(5.dp,40.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("999",
                            fontSize = 15.sp)
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.background),
                            contentDescription = "PowerLine"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("999",
                            fontSize = 15.sp)
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.background),
                            contentDescription = "PowerLine"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("999",
                            fontSize = 15.sp)
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.background),
                            contentDescription = "PowerLine"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("999",
                            fontSize = 15.sp)
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.background),
                            contentDescription = "PowerLine"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("999",
                            fontSize = 15.sp)
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.background),
                            contentDescription = "PowerLine"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text("999",
                            fontSize = 15.sp)
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.background),
                            contentDescription = "PowerLine"
                        )
                    }
                }
            }
        }

        //PokemonImage
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.image),
            contentDescription = "PokemonImage",
            modifier = Modifier.align(Alignment.TopCenter).padding(0.dp,100.dp,0.dp,0.dp).size(200.dp,200.dp)
        )
    }
}



