package com.example.kotlin.pokedexapp2.data.network.model.pokemon

data class Ability(
    val ability: com.example.kotlin.pokedexapp2.data.network.model.pokemon.AbilityX,

    val is_hidden: Boolean,
    val slot: Int
)