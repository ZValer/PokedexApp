package com.example.kotlin.pokedexapp2.domain

import com.example.kotlin.pokedexapp2.data.PokemonRepository
import com.example.kotlin.pokedexapp2.data.network.model.pokemon.Pokemon

// Representa un caso de uso para obtener la información de un Pokémon
// específico. Se encarga de la lógica de negocio relacionada con la
// obtención de información de un Pokémon.

class PokemonInfoRequirement {

    // Instancia del repositorio.
    private val repository = PokemonRepository()

    // Utiliza el repositorio para llamar a la API y obtener los datos del Pokémon.
    suspend operator fun invoke(
        numberPokemon: Int  // Número del Pokémon que se quiere obtener (e.g., 25 para Pikachu).
    ): Pokemon? = repository.getPokemonInfo(numberPokemon)
}
