package com.example.profiki.ui.UI.Pokemons.PokemonsComponents

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ParameterBox(modifier: Modifier, @DrawableRes parameterImage: Int, parameterValue: String, parameterName: String){
    Box (
        modifier = modifier.fillMaxHeight().fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth().padding(0.dp, 8.dp, 0.dp , 0.dp).align(Alignment.TopCenter)

        ) {
            Image(
                imageVector = ImageVector.vectorResource(parameterImage),
                contentDescription = "ParameterImage",
                modifier = Modifier.size(15.dp, 16.dp)
            )
            Text(parameterValue,
                fontSize = 15.sp,
                modifier = Modifier.padding(4.dp,0.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxHeight(0.5f).align(Alignment.BottomCenter)
        ) {
            Text(parameterName,
                fontSize = 13.sp)
        }
    }
}