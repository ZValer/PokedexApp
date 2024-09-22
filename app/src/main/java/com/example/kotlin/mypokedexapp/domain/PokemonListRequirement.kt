package com.example.kotlin.mypokedexapp.domain

import com.example.kotlin.mypokedexapp.data.PokemonRepository
import com.example.kotlin.mypokedexapp.data.network.model.PokedexObject

// Caso de uso en la capa de dominio.
// Encapsula la lógica para obtener una lista de Pokémon de la API, utilizando un límite
// específico.
// La clase interactúa con el PokemonRepository para recuperar los datos.
class PokemonListRequirement {

    // Una referencia al PokemonRepository, que maneja la obtención de datos de la capa de datos (API).
    private val repository = PokemonRepository()

    // La función invoke es una función operadora de Kotlin, que permite llamar a la clase
    // como una función.
    // Obtiene una lista de Pokémon del repositorio, con el límite especificado en el número
    // de Pokémon a recuperar.
    // Si la solicitud falla (por ejemplo, error de red), devuelve null.
    suspend operator fun invoke(
        limit: Int
    ): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject? =
        repository.getPokemonList(limit)
}
