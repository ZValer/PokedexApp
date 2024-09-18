package com.example.kotlin.pokedexapp2.data.network.model

import com.google.gson.annotations.SerializedName

// Clase de datos que representa la estructura básica de un Pokémon, tal como
// lo recibe la API. Se utiliza para mapear los detalles básicos (nombre y URL)
// de cada Pokémon en la respuesta JSON.

data class PokemonBase(
    @SerializedName("name") val name: String,  // Nombre del Pokémon

    // Enlace que contiene más detalles sobre el Pokémon.
    // Se utiliza para hacer una solicitud de info más detallada a la API.
    @SerializedName("url") val url: String
)
