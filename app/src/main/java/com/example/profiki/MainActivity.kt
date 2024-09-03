package com.example.profiki

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profiki.ui.theme.ProfikiTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfikiTheme {
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

    @Composable
    fun AppTopBar(){
        Column {
            Row(modifier = Modifier.fillMaxWidth().background(Color.Red), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.pokeball),
                    contentDescription = "pokeball"
                )
                Text("Pokédex", fontSize = 32.sp, color = Color.White, modifier = Modifier.padding(10.dp).align(Alignment.Top))
            }
            Row(modifier = Modifier.fillMaxWidth().background(Color.Red), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {

                Button(onClick = {}, shape = (R.drawable.baseline_circle_24)) {
                    Text("#", color = Color.Red)
                }
            }
        }


    }

}


