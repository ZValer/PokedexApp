package com.example.kotlin.mypokedexapp.domain

import com.example.kotlin.mypokedexapp.data.PokemonRepository
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon

// The PokemonInfoRequirement class serves as a use case in the domain layer.
// It defines a specific operation: fetching detailed information about a Pokémon.
// The class interacts with the repository to retrieve the necessary data.
class PokemonInfoRequirement {

    // A reference to the PokemonRepository, which is responsible for fetching data from the data source (API).
    private val repository = PokemonRepository()

    // The invoke function is a Kotlin operator function, which allows the class to be called like a function.
    // It fetches detailed information about a Pokémon using its number and returns a Pokemon object.
    // If the request fails (e.g., network error), it returns null.
    suspend operator fun invoke(
        numberPokemon: Int
    ): com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon? =
        repository.getPokemonInfo(numberPokemon)
}
