package com.example.profiki.Data

data class PokemonItemsResponse(
    val count:Int,
    val next:String?,
    val previous:String?,
    val results:List<PokemonItemResponse>
)
data class PokemonItemResponse(
    val name:String,
    val url:String
)
