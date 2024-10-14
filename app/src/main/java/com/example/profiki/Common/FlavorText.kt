package com.example.profiki.Common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.profiki.Data.Model.FlavorText
import com.example.profiki.Data.Model.PokemonResponse
import com.example.profiki.Data.Model.SpeciesPokemonResponse

fun FlavorTextEn(species: SpeciesPokemonResponse?): String {
        return species?.flavor_text_entries?.firstOrNull {
            it.language.name.contains("en")
        }
            ?.flavor_text.toString()
}