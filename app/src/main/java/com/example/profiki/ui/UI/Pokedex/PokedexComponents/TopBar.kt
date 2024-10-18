@file:Suppress("UNUSED_EXPRESSION")

package com.example.profiki.ui.UI.Pokedex.PokedexComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.Data.Model.StateSort
import com.example.profiki.R


@Composable
fun AppTopBar(
    onSortModeChange: (StateSort) -> Unit,
    searchText: String,
    onValueChange: (String)-> Unit,
    clearText: () -> Unit
){
    var sortMode by remember { mutableStateOf(StateSort.NUMBER) }
    var active by remember { mutableStateOf(false) }
    Column(modifier = Modifier.background(Color.Red) ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
            .fillMaxHeight(0.08f),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.pokeball),
                contentDescription = "pokeball",
                modifier = Modifier
                    .padding(16.dp, 0.dp, 0.dp, 16.dp)
                    .size(30.dp, 30.dp)
            )
            Text("Pokédex",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 12.dp ))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .fillMaxHeight(0.08f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically)
        {
            SearchBar(
                searchText = searchText,
                onValueChange = onValueChange,
                modifier = Modifier
                    .padding(16.dp, 0.dp, 16.dp, 20.dp)
                    .height(45.dp)
                    .weight(1f),
                clearText = {
                     clearText
                }
            )
            Button(onClick = { active = true},
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Red,
                    containerColor = Color.White),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .padding(0.dp, 0.dp, 12.dp, 24.dp)
                    .size(45.dp)
            ) {
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                    contentAlignment = Alignment.Center){
                    Image(
                        modifier = Modifier.size(15.dp),
                        imageVector = ImageVector.vectorResource(if (sortMode == StateSort.NUMBER){
                            R.drawable.tag} else {
                            R.drawable.text_format}),
                        contentDescription = "Pokemon",
                        alignment = Alignment.Center)
                }
                /*DropdownMenu(
                    active = active,
                    sortMode = sortMode,
                    onDismissRequest = {active = false},
                    onClickNumber = {
                        onSortModeChange(StateSort.NUMBER)
                        sortMode = StateSort.NUMBER
                    },
                    onClickName = {
                        onSortModeChange(StateSort.NAME)
                        sortMode = StateSort.NAME
                    }
                )*/
                DropdownMenu (
                    expanded = active,
                    onDismissRequest = { active = false },
                    modifier = Modifier.background(Color.Red)

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight(0.5f)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Sort by:",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
                        )
                    }
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.7f)
                            .padding(4.dp, 4.dp, 4.dp, 0.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.35f),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = sortMode == StateSort.NUMBER,
                                onClick = {
                                    onSortModeChange(StateSort.NUMBER)
                                    sortMode = StateSort.NUMBER
                                },
                                colors = RadioButtonColors(
                                    selectedColor = Color.Red,
                                    unselectedColor = Color.Red,
                                    disabledSelectedColor = Color.White,
                                    disabledUnselectedColor = Color.White
                                )
                            )
                            Text(
                                "Number",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium

                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.35f),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = sortMode == StateSort.NAME,
                                onClick = {
                                    onSortModeChange(StateSort.NAME)
                                    sortMode = StateSort.NAME
                                },
                                colors = RadioButtonColors(
                                    selectedColor = Color.Red,
                                    unselectedColor = Color.Red,
                                    disabledSelectedColor = Color.White,
                                    disabledUnselectedColor = Color.White
                                )
                            )

                            Text(
                                "Name",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp)
                            )
                        }
                    }
                }
            }
        }

    }
}