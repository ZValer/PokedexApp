package com.example.kotlin.pokedexapp2.domain

import com.example.kotlin.pokedexapp2.data.PokemonRepository
import com.example.kotlin.pokedexapp2.data.network.model.PokedexObject

class PokemonListRequirement {
    private val repository = PokemonRepository()

    suspend operator fun invoke(
        limit:Int
    ): PokedexObject? = repository.getPokemonList(limit)
}