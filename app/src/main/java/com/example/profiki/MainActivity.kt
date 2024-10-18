package com.example.profiki

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import com.example.profiki.DI.appModule
import com.example.profiki.ui.UI.Pokedex.PokedexScreen
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin{modules(appModule)}

        enableEdgeToEdge()
        setContent {
            Navigator(PokedexScreen())
        }
    }
}



