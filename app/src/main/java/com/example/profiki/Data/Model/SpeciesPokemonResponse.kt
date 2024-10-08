package com.example.profiki.Data.Model

data class SpeciesPokemonResponse(
    val color: UrlResource,
    val flavor_text_entries:List<FlavorText>
)
data class FlavorText(
    val flavor_text: String,
    val language: UrlResource
)