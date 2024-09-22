package com.example.kotlin.mypokedexapp.data.network.model

import com.google.gson.annotations.SerializedName

// Clase de datos que representa info básica sobre un Pokémon en la respuesta de la API.
data class PokemonBase(
    // La anotación @SerializedName mapea el campo JSON "name" a esta propiedad.
    // Almacena el nombre del Pokémon.
    @SerializedName("name") val name: String,

    // La anotación @SerializedName mapea el campo JSON "url" a esta propiedad.
    // Almacena la URL que contiene más información sobre el Pokémon.
    @SerializedName("url") val url: String
)
