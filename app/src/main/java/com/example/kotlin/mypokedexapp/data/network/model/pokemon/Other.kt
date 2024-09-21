package com.example.kotlin.mypokedexapp.data.network.model.pokemon

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world") val dream_world: com.example.kotlin.mypokedexapp.data.network.model.pokemon.DreamWorld,
    @SerializedName("home") val home: com.example.kotlin.mypokedexapp.data.network.model.pokemon.Home,
    @SerializedName("official-artwork") val official_artwork: com.example.kotlin.mypokedexapp.data.network.model.pokemon.OfficialArtwork,
    @SerializedName("showdown") val showdown: com.example.kotlin.mypokedexapp.data.network.model.pokemon.Showdown
)