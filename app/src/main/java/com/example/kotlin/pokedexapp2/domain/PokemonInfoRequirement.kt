package com.example.kotlin.pokedexapp2.domain

import com.example.kotlin.pokedexapp2.data.PokemonRepository
import com.example.kotlin.pokedexapp2.data.network.model.pokemon.Pokemon

class PokemonInfoRequirement {
    private val repository = PokemonRepository()

    suspend operator fun invoke(
        numberPokemon:Int
    ): Pokemon? = repository.getPokemonInfo(numberPokemon)
}