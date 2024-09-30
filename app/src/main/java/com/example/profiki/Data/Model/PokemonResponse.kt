package com.example.profiki.Data.Model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id:Int,
    val name:String,
    val height:Int,
    val weight:Int,
    val order:Int,
    val types:List<TypesResponse>,
    val abilities: List<AbilityResponse>,
    val species:UrlResource,
    val stats:List<StatsResponse>,
    val sprites:SpiritesResponse
)
data class SpiritesResponse(
    val other:OfficialSpiriteResponse
)
data class AbilityResponse(
    val ability:UrlResource
)
data class OfficialSpiriteResponse(
    @SerializedName("official-artwork")
    val official_artwork:OfficialArtWorkResponse
)
data class OfficialArtWorkResponse(
    val front_default:String,
    val front_shiny:String
)
data class StatsResponse(
    val base_stat:Int,
    val stat:UrlResource
)
data class  UrlResource(
    val name: String,
    val url: String
)

data class TypesResponse(
    val slot:Int,
    val type:UrlResource
)