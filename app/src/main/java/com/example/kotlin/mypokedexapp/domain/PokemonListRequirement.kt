package com.example.kotlin.mypokedexapp.domain

import com.example.kotlin.mypokedexapp.data.PokemonRepository
import com.example.kotlin.mypokedexapp.data.network.model.PokedexObject

// The PokemonListRequirement class represents a use case in the domain layer.
// It encapsulates the logic for fetching a list of Pokémon from the API, using a specific limit.
// The class interacts with the repository to retrieve the data.
class PokemonListRequirement {

    // A reference to the PokemonRepository, which handles fetching data from the data layer (API).
    private val repository = PokemonRepository()

    // The invoke function is a Kotlin operator function, allowing the class to be called like a function.
    // It fetches a list of Pokémon from the repository, with the specified limit on the number of Pokémon to retrieve.
    // If the request fails (e.g., network error), it returns null.
    suspend operator fun invoke(
        limit: Int
    ): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject? =
        repository.getPokemonList(limit)
}
