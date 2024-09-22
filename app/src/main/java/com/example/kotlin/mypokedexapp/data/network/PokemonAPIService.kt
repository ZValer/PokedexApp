package com.example.kotlin.mypokedexapp.data.network

import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Esta interfaz define los endpoints de la API para interactuar con la API de Pokémon
// utilizando Retrofit.
// Retrofit genera automáticamente el código de solicitud de red basado en estas firmas de
// métodos.
interface PokemonAPIService {

    // Endpoint: https://pokeapi.co/api/v2/pokemon/?limit=1279
    // Función para obtener una lista de Pokémon desde la API.
    // La anotación @GET especifica que este método realiza una solicitud HTTP GET al endpoint
    // "pokemon".
    @GET("pokemon")
    suspend fun getPokemonList(

        // La anotación @Query se usa para añadir el parámetro "limit" a la URL de la solicitud.
        // Esto te permite especificar el número de Pokémon que quieres recuperar.
        @Query("limit") limit: Int
    ): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject
    // La función devuelve un PokedexObject (una lista de Pokémon) en una función suspend para
    // ejecución asíncrona.

    // Endpoint: https://pokeapi.co/api/v2/pokemon/{number_pokemon}/
    // Función para obtener información detallada sobre un Pokémon específico basado en su número.
    @GET("pokemon/{numberPokemon}")
    suspend fun getPokemonInfo(

        // La anotación @Path se usa para sustituir el valor de numberPokemon en la ruta de la
        // URL. Esto recupera info detallada sobre el Pokémon con el número dado.
        @Path("numberPokemon") numberPokemon: Int
    ): com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
}
