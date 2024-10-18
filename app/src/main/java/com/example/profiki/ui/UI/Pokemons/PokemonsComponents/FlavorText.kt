package com.example.profiki.ui.UI.Pokemons.PokemonsComponents

import com.example.profiki.Data.Model.SpeciesPokemonResponse

fun FlavorTextEn(species: SpeciesPokemonResponse?): String {
        return species?.flavor_text_entries?.firstOrNull {
            it.language.name.contains("en")
        }
            ?.flavor_text?.replace("\n", " ").toString()
}