package com.example.kotlin.mypokedexapp.domain

import com.example.kotlin.mypokedexapp.data.PokemonRepository
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon

// Caso de uso en la capa de dominio.
// Define una operación específica: obtener información detallada sobre un Pokémon.
// La clase interactúa con el repositorio para recuperar los datos necesarios.
class PokemonInfoRequirement {
    // Una referencia al PokemonRepository, que es responsable de obtener datos de la fuente de
    // datos (API).
    private val repository = PokemonRepository()

    // La función invoke es una función operadora de Kotlin, que permite que la clase se llame como
    // una función.
    // Obtiene información detallada sobre un Pokémon usando su número y devuelve un objeto Pokémon.
    // Si la solicitud falla (por ejemplo, error de red), devuelve null.
    suspend operator fun invoke(
        numberPokemon: Int
    ): com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon? =
        repository.getPokemonInfo(numberPokemon)
}
