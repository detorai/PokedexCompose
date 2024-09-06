package com.example.profiki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.ui.theme.ProfikiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfikiTheme {

                val text by remember {
                    mutableStateOf("")
                }
                Scaffold(
                    topBar = { AppTopBar() }
//                        TopAppBar(
//                            title = { Text("Pokédex", fontSize = 32.sp) },
//
//                            colors = TopAppBarDefaults.topAppBarColors(
//                                containerColor = Color.Red,
//                                titleContentColor = Color.White
//                            )
//                        )
//                    })
                ){
                    Text("hello world", modifier = Modifier.padding(it))
                }
                }
            }
        }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppTopBar(){
        var text by remember { mutableStateOf("") }
        var state by remember { mutableStateOf(true) }
        var active by remember { mutableStateOf(false) }
        Column(modifier = Modifier.background(Color.Red) ) {
            Row(modifier = Modifier.fillMaxWidth().background(Color.Red).fillMaxHeight(0.1f), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.pokeball),
                    contentDescription = "pokeball",
                    modifier = Modifier.padding(12.dp,16.dp, 0.dp, 0.dp).size(28.dp,28.dp)
                )
                Text("Pokédex",
                    fontSize = 32.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp, 30.dp, 0.dp, 0.dp )
                        .align(Alignment.Top))
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(Color.Red).fillMaxHeight(0.1f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically)
            {
                OutlinedTextField(
                    modifier = Modifier.padding(12.dp,0.dp, 16.dp, 24.dp).height(45.dp).weight(1f),
                    shape = RoundedCornerShape(20.dp),
                    value = text,
                    onValueChange = {text = it},
                    placeholder = {Text("Search",
                        color = Color.Gray,
                        modifier = Modifier.align(Alignment.CenterVertically))},
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
                    modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 24.dp).size(45.dp,45.dp)) {
                    DropdownMenu(
                        expanded = active,
                        onDismissRequest = { active = false }
                    ) {
                        Row {
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
                            Text("Number")
                        }
                        Row {
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
                            Text("Name")
                        }

                    }
                }
            }
        }
        @Composable
        fun CardMinimalExample() {
            Card() {
                Text(text = "Hello, world!")
            }
        }

    }
}


//SearchBar(
//modifier = Modifier.size(300.dp,80.dp),
//colors = SearchBarDefaults.colors(Color.White),
//query = text,
//onQueryChange = {text = it},
//onSearch = {active = false},
//active = active,
//onActiveChange = {active = it},
//placeholder = {Text("Search", color = Color.Red)},
//leadingIcon = {
//    Icon(
//        imageVector = Icons.Default.Search,
//        contentDescription = "Search Icon",
//        tint = Color.Red)},
//trailingIcon = {
//    if (active) {
//        Icon(
//            modifier = Modifier.clickable {
//                if (text.isNotEmpty()) {
//                    text = ""
//                } else {
//                    active = false
//                }
//            },
//            imageVector = Icons.Default.Clear,
//            contentDescription = "Close Icon",
//            tint = Color.Red
//        )
//    }
//})
//{ }