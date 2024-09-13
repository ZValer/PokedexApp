package com.example.kotlin.pokedexapp2.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIii(
    val emerald: com.example.kotlin.pokedexapp2.model.pokemon.Emerald,
    @SerializedName("firered-leafgreen") val firered_leafgreen: com.example.kotlin.pokedexapp2.model.pokemon.FireredLeafgreen,
    @SerializedName("ruby-sapphire") val ruby_sapphire: com.example.kotlin.pokedexapp2.model.pokemon.RubySapphire
)
