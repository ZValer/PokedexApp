package com.example.kotlin.pokedexapp2.domain

import com.example.kotlin.pokedexapp2.data.PokemonRepository
import com.example.kotlin.pokedexapp2.data.network.model.PokedexObject

// Representa un caso de uso para obtener una lista de Pokémon.
// Encargándose de la lógica de negocio relacionada con la obtención
// de una lista de Pokémon.

class PokemonListRequirement {

    // Instancia del repositorio.
    private val repository = PokemonRepository()

    // Utiliza el repositorio para realizar la solicitud a la API
    suspend operator fun invoke(
        limit: Int  // Límite de Pokémon a obtener (por ejemplo, 150).
    ): PokedexObject? = repository.getPokemonList(limit)
}
