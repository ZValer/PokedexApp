package com.example.kotlin.pokedexapp2.model.pokemon

import com.google.gson.annotations.SerializedName

data class Other(
    val dream_world: com.example.kotlin.pokedexapp2.model.pokemon.DreamWorld,
    val home: com.example.kotlin.pokedexapp2.model.pokemon.Home,
    @SerializedName("official-artwork") val official_artwork: com.example.kotlin.pokedexapp2.model.pokemon.OfficialArtwork,
    val showdown: com.example.kotlin.pokedexapp2.model.pokemon.Showdown
)