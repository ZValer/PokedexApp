package com.example.kotlin.mypokedexapp.data.network.model

import com.google.gson.annotations.SerializedName

// A data class that represents the structure of the Pokedex object received from the API.
data class PokedexObject(
    // The @SerializedName annotation maps the JSON field "count" to this property.
    @SerializedName("count") val count: Int,

    /*
    * This annotation is used to map the count property to the corresponding field
    * in the JSON response. When the JSON object from the API contains a field called "count",
    * it will be automatically mapped to this count property in Kotlin.
    * val count: Int: Holds the total number of Pokémon available in the Pokedex.
    * */

    // The @SerializedName annotation maps the JSON field "results" to this property.
    // It holds an ArrayList of PokemonBase objects, which represents the list of Pokémon data.
    @SerializedName("results") val results: ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase>
)
