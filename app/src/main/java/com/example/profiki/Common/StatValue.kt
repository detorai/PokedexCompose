package com.example.profiki.Common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.R
import org.w3c.dom.Text

@Composable
fun StatValue(modifier: Modifier, value: String, progressLine: Float  ) {

    LazyColumn (
        modifier = modifier.padding(0.dp, 0.dp, 16.dp, 0.dp ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        items(6){
            Text(value,
                fontSize = 15.sp)
        }
    }
    LazyColumn (
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        items(6){
            LinearProgressIndicator(
                progress = { progressLine },
                color = Color.Gray,
                trackColor = Color.White
            )
        }
    }
}