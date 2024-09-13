package com.example.kotlin.pokedexapp2.model.pokemon

data class Move(
    val move: com.example.kotlin.pokedexapp2.model.pokemon.MoveX,
    val version_group_details: List<com.example.kotlin.pokedexapp2.model.pokemon.VersionGroupDetail>
)