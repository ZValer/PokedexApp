package com.example.kotlin.mypokedexapp.data.network.model

import com.google.gson.annotations.SerializedName

// Una data class que representa la estructura del objeto Pokedex recibido de la API.
data class PokedexObject(
    // La anotación @SerializedName asigna el campo JSON "count" a esta propiedad.
    @SerializedName("count") val count: Int,

    /*
    * Esta anotación se utiliza para mapear la propiedad count al campo correspondiente
    * en la respuesta JSON. Cuando el objeto JSON de la API contiene un campo llamado "count",
    * se asignará automáticamente a esta propiedad count en Kotlin.
    * val count: Int: Almacena el número total de Pokémon disponibles en la Pokédex.
    * */

    // La anotación @SerializedName asigna el campo JSON "results" a esta propiedad.
    // Contiene un ArrayList de objetos PokemonBase, que representa la lista de datos de
    // los Pokémon.
    @SerializedName("results") val results: ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase>
)
