package com.example.profiki.Common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.Data.Model.PokemonResponse

@Composable
fun TypeRow(modifier: Modifier, pokemon: PokemonResponse?){
    LazyRow(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        if (pokemon != null) {
            items(pokemon.types){ type ->
                Text(
                    type.type.name,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(8.dp, 0.dp)
                        .background(
                            Color.DarkGray,
                            shape = RoundedCornerShape(18.dp)
                        ).padding(8.dp, 4.dp)
                )
            }
        }
    }
}
