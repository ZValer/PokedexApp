package com.example.kotlin.pokedexapp2.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("black-white") val black_white: com.example.kotlin.pokedexapp2.model.pokemon.BlackWhite
)