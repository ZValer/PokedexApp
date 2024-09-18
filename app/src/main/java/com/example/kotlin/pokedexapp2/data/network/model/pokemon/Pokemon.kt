package com.example.kotlin.pokedexapp2.data.network.model.pokemon
import com.example.kotlin.pokedexapp2.data.network.model.pokemon.Ability

data class Pokemon(
    val abilities: List<Ability>,
    val base_experience: Int,
    val cries: com.example.kotlin.pokedexapp2.data.network.model.pokemon.Cries,
    val forms: List<com.example.kotlin.pokedexapp2.data.network.model.pokemon.Form>,
    val game_indices: List<com.example.kotlin.pokedexapp2.data.network.model.pokemon.GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<com.example.kotlin.pokedexapp2.data.network.model.pokemon.Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: com.example.kotlin.pokedexapp2.data.network.model.pokemon.Species,
    val sprites: com.example.kotlin.pokedexapp2.data.network.model.pokemon.Sprites,
    val stats: List<com.example.kotlin.pokedexapp2.data.network.model.pokemon.Stat>,
    val types: List<com.example.kotlin.pokedexapp2.data.network.model.pokemon.Type>,
    val weight: Int
)