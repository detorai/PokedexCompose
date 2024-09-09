package com.example.profiki

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.ui.theme.ProfikiTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfikiTheme {
                Scaffold(
                    topBar = { AppTopBar() }
//
                ){ innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                    FilledCardExample()
                    }
                }
                }
            }
        }


    @Composable
    fun AppTopBar(){
        var text by remember { mutableStateOf("") }
        var state by remember { mutableStateOf(true) }
        var active by remember { mutableStateOf(false) }
        Column(modifier = Modifier.background(Color.Red) ) {
            Row(modifier = Modifier.fillMaxWidth()
                .background(Color.Red)
                .fillMaxHeight(0.08f),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.pokeball),
                    contentDescription = "pokeball",
                    modifier = Modifier.padding(12.dp,0.dp, 0.dp, 12.dp).size(30.dp,30.dp)
                )
                Text("Pokédex",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 8.dp ))
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Red).fillMaxHeight(0.08f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically)
            {
                OutlinedTextField(
                    textStyle = TextStyle(baselineShift = BaselineShift(0.1f)),
                    modifier = Modifier.padding(12.dp,0.dp, 16.dp, 24.dp).height(45.dp).weight(1f),
                    shape = RoundedCornerShape(20.dp),
                    value = text,
                    onValueChange = {text = it},
                    placeholder = {
                        Row(
                            modifier = Modifier.fillMaxWidth().fillMaxHeight().align(Alignment.Top)) {
                        Text("Search",
                        color = Color.Gray,
                    )}
                                  },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = Color.Red)},
                    trailingIcon = {
                        Icon(
                            modifier = Modifier.clickable {
                                if (text.isNotEmpty()) {
                                    text = ""
                                }
                                else {

                                }
                            },
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Close Icon",
                            tint = Color.Red
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(unfocusedContainerColor = Color.White, focusedContainerColor = Color.White )

                )
                Button(onClick = { active = true},
                    shape = RoundedCornerShape(80),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Red,
                        containerColor = Color.White),
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 24.dp)
                        .size(45.dp,45.dp)
                ) {
                    DropdownMenu(
                        expanded = active,
                        onDismissRequest = { active = false },
                        modifier = Modifier.background(Color.Red)

                    ) {
                        Row(
                            modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("Sort by:",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(0.dp,0.dp,8.dp,0.dp)
                                )
                        }
                        Card(
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.7f)
                                .padding(4.dp,4.dp,4.dp,0.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.35f),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = state,
                                    onClick = { state = true },
                                    colors = RadioButtonColors(
                                        selectedColor = Color.Red,
                                        unselectedColor = Color.Red,
                                        disabledSelectedColor = Color.White,
                                        disabledUnselectedColor = Color.White
                                    )
                                )
                                Text("Number",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium

                                )
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.35f),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = !state,
                                    onClick = { state = false },
                                    colors = RadioButtonColors(
                                        selectedColor = Color.Red,
                                        unselectedColor = Color.Red,
                                        disabledSelectedColor = Color.White,
                                        disabledUnselectedColor = Color.White
                                    )
                                )

                                Text("Name",
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(0.dp,0.dp,20.dp,0.dp))
                            }
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun FilledCardExample() {
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
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier.padding(8.dp)
                            .size(104.dp,108.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 6.dp
                        )
                            ){
                        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight()){
                                       Text(
                                           "#999",
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
                                                   "Pokémon Name",
                                                   color = Color.Black,
                                                   fontSize = 10.sp,

                                               )
                                        }}
                            Image(
                                modifier = Modifier.align(Alignment.Center),
                                imageVector = ImageVector.vectorResource(R.drawable.image),
                                contentDescription = "Pokemon",
                                alignment = Alignment.Center



                            )
                            }
                    }}
            }
        }
    }
}


