package com.example.profiki.ui.UI

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.Common.Abilities
import com.example.profiki.Common.FlavorTextEn
import com.example.profiki.Common.colorName
import com.example.profiki.Common.ParameterBox
import com.example.profiki.Common.StatName
import com.example.profiki.Common.StatValue
import com.example.profiki.Common.TypeRow
import com.example.profiki.Common.colorDopName
import com.example.profiki.Common.colorType
import com.example.profiki.Common.loadImage
import com.example.profiki.Common.pokemonNumber
import com.example.profiki.Data.Model.FlavorText
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.SpeciesPokemonResponse
import com.example.profiki.R
import java.util.Locale


@Composable
fun Pokemons(pokemon: PokemonResponse?, onClickBack: ()-> Unit, species: SpeciesPokemonResponse?){

    Box(
        modifier = Modifier.background(color = colorName(pokemon))
            .fillMaxHeight()
            .fillMaxWidth()
    ){
        Image(imageVector = ImageVector.vectorResource(R.drawable.pokeball),
            contentDescription = "pokeball",
            colorFilter = ColorFilter.tint(color = colorDopName(pokemon)),
            modifier = Modifier.size(246.dp,248.dp).padding(0.dp,8.dp, 9.dp, 0.dp).align(Alignment.TopEnd),
            )

        //TopNameRow
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(4.dp,20.dp).align(Alignment.TopCenter)
        ) {
            IconButton(
                onClick = onClickBack
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Search Icon",
                    tint = Color.White,
                    modifier = Modifier.size(21.dp,21.dp)
                )
            }
            Text(
                pokemon?.name?.capitalize(Locale.ROOT).toString(),
                color = Color.White,
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp, 0.dp, 150.dp, 0.dp)
                )
            Text(
                text = pokemonNumber(pokemon?.order),
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp)
                )
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
                modifier = Modifier.fillMaxWidth().padding(20.dp,92.dp,20.dp,0.dp)
            ) {
                Text("About",
                    color = colorName(pokemon),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                    )
            }

            //Characteristics Row
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(1f).fillMaxHeight(0.2f).padding(0.dp,16.dp)
            ) {

                ParameterBox(modifier = Modifier.fillMaxHeight().fillMaxWidth(0.2f),
                    parameterName = "Weight",
                    parameterValue = "${pokemon?.weight?.toFloat()?.div(10)} kg",
                    parameterImage = R.drawable.weight
                )

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.divider),
                    contentDescription = "divider",
                    modifier = Modifier.fillMaxHeight(),
                    contentScale = ContentScale.FillBounds
                )
                ParameterBox(modifier = Modifier.fillMaxHeight().fillMaxWidth(0.2f),
                    parameterName = "Height",
                    parameterValue = "${pokemon?.height?.toFloat()?.div(10)} m",
                    parameterImage = R.drawable.straighten
                )

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
                        .fillMaxHeight().fillMaxWidth(0.3f)
                ) {
                   Abilities(pokemon)
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
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.padding(20.dp,16.dp).fillMaxWidth()
            ) {
                Text( text = FlavorTextEn(species),
                    fontSize = 15.sp)
            }

            //Text 2 Row
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(20.dp,16.dp)
            ) {
                Text("Base Stats",
                    color = colorName(pokemon),
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    softWrap = false
                    )
            }

            //Base Stats Row
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.7f).padding(0.dp,16.dp)
            ) {
                StatName(
                    modifier = Modifier.fillMaxHeight().padding(20.dp, 0.dp, 16.dp, 0.dp),
                    color = colorName(pokemon)
                )

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.divider),
                    contentDescription = "divider",
                    modifier = Modifier.fillMaxHeight().padding(0.dp, 0.dp, 16.dp, 0.dp),
                    contentScale = ContentScale.FillBounds
                )
                StatValue(
                    stateValue = pokemon,
                    modifier = Modifier.fillMaxHeight(),
                    color = colorName(pokemon),
                    colorDop = colorDopName(pokemon))

            }
        }

        //PokemonImage
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f)
        ){
        Image(
            bitmap = loadImage(pokemon?.sprites?.other?.official_artwork?.front_default.toString()),
            contentDescription = "PokemonImage",
            modifier = Modifier.align(Alignment.TopCenter).padding(0.dp,100.dp,0.dp,0.dp).size(230.dp,230.dp).align(Alignment.TopCenter)
        )
            //Type Row
            TypeRow(
                modifier = Modifier.fillMaxWidth()
                    .padding(20.dp,0.dp,20.dp,100.dp).align(Alignment.BottomCenter),
                pokemon = pokemon
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().align(Alignment.Center).padding(18.dp, 0.dp)
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




