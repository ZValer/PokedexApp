package com.example.kotlin.pokedexapp2.data.network.model

import com.google.gson.annotations.SerializedName

// Clase de datos que mapea la respuesta JSON obtenida del servidor a un
// objeto Kotlin. Representa la respuesta completa de una solicitud a la
// API de Pokémon.

data class PokedexObject(
    @SerializedName("count") val count: Int,  // El número total de Pokémon

    // Lista de objetos de tipo 'PokemonBase' que representan cada Pokémon.
    // Esta lista almacena detalles básicos de cada uno.
    @SerializedName("results") val results: ArrayList<com.example.kotlin.pokedexapp2.data.network.model.PokemonBase>
)
