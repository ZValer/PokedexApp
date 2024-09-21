package com.example.kotlin.mypokedexapp.data.network.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue") val red_blue: com.example.kotlin.mypokedexapp.data.network.model.pokemon.RedBlue,
    @SerializedName("yellow") val yellow: com.example.kotlin.mypokedexapp.data.network.model.pokemon.Yellow
)