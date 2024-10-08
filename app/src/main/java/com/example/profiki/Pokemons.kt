@file:Suppress("UNUSED_EXPRESSION")

package com.example.profiki

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.Ul.Common.ParameterBox
import com.example.profiki.Ul.Common.StatName
import com.example.profiki.Ul.Common.StatValue


@Composable
fun Pokemons(onClickBack: ()-> Unit) {
    Box(
        modifier = Modifier
            .background(Color(184, 184, 184))
            .fillMaxHeight()
            .fillMaxWidth()
    ){
        Image(imageVector = ImageVector.vectorResource(R.drawable.pokeball),
            contentDescription = "pokeball",
            colorFilter = ColorFilter.tint(color = Color.LightGray),
            modifier = Modifier
                .size(246.dp, 248.dp)
                .padding(0.dp, 8.dp, 9.dp, 0.dp)
                .align(Alignment.TopEnd),
            )

        //TopNameRow
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp, 20.dp)
                .align(Alignment.TopCenter)
        ) {
            IconButton(
                onClick = onClickBack,
            ) {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Search Icon",
                tint = Color.White
                )}
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

            //Text Row
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 92.dp, 20.dp, 0.dp)
            ) {
                Text("About",
                    color = Color.Gray,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                    )
            }

            //Characteristics Row
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(0.dp, 16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f)
            ) {

                ParameterBox(modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight(),
                    parameterName = "Weight",
                    parameterValue = "9,9kg",
                    parameterImage = R.drawable.weight)

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.divider),
                    contentDescription = "divider",
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.FillBounds
                )
                ParameterBox(modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.2f),
                    parameterName = "Height",
                    parameterValue = "9,9m",
                    parameterImage = R.drawable.weight)

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.divider),
                    contentDescription = "divider",
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.25f)
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 16.dp)
            ) {
                Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc iaculis eros vitae tellus condimentum maximus sit amet in eros.",
                    fontSize = 15.sp)
            }

            //Text 2 Row
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 16.dp)
            ) {
                Text("Base Stats",
                    color = Color.Gray,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                    )
            }

            //Base Stats Row
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .padding(0.dp, 16.dp)
            ) {
                StatName(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(20.dp, 0.dp, 16.dp, 0.dp)
                )

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.divider),
                    contentDescription = "divider",
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(0.dp, 0.dp, 16.dp, 0.dp),
                    contentScale = ContentScale.FillBounds
                )
                StatValue(modifier = Modifier. fillMaxHeight(), value = "999", progressLine = 0.5f)

            }
        }

        //PokemonImage
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ){
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.image),
            contentDescription = "PokemonImage",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(0.dp, 100.dp, 0.dp, 0.dp)
                .size(200.dp, 200.dp)
                .align(Alignment.TopCenter)
        )
            //Type Row
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 20.dp, 100.dp)
                    .align(Alignment.BottomCenter)
            ){
                Text("Type",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp, 0.dp)
                        .background(
                            Color.DarkGray,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .padding(8.dp, 4.dp)
                )

                Text("Type",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(8.dp, 0.dp)
                        .background(
                            Color.DarkGray,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .padding(8.dp, 4.dp)

                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(18.dp, 0.dp)
            ) {
                Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
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



