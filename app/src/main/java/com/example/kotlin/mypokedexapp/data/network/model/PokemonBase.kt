package com.example.kotlin.mypokedexapp.data.network.model

import com.google.gson.annotations.SerializedName

// A data class that represents basic information about a single Pokémon in the API response.
data class PokemonBase(
    // The @SerializedName annotation maps the JSON field "name" to this property.
    // It stores the name of the Pokémon.
    @SerializedName("name") val name: String,

    // The @SerializedName annotation maps the JSON field "url" to this property.
    // It stores the URL that contains more information about the Pokémon.
    @SerializedName("url") val url: String
)
