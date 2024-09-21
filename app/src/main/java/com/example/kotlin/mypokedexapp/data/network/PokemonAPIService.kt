package com.example.kotlin.mypokedexapp.data.network

import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// This interface defines the API endpoints for interacting with the Pokémon API using Retrofit.
// Retrofit automatically generates the network request code based on these method signatures.
interface PokemonAPIService {

    // Endpoint: https://pokeapi.co/api/v2/pokemon/?limit=1279
    // Function to get a list of Pokémon from the API.
    // The @GET annotation specifies that this method performs an HTTP GET request to the "pokemon" endpoint.
    @GET("pokemon")
    suspend fun getPokemonList(

        // The @Query annotation is used to append the "limit" parameter to the request URL.
        // This allows you to specify the number of Pokémon to retrieve.
        @Query("limit") limit: Int
    ): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject
    // The function returns a PokedexObject (a list of Pokémon) in a suspend function for asynchronous execution.

    // Endpoint: https://pokeapi.co/api/v2/pokemon/{number_pokemon}/
    // Function to get detailed information about a specific Pokémon based on its number.
    @GET("pokemon/{numberPokemon}")
    suspend fun getPokemonInfo(

        // The @Path annotation is used to substitute the value of numberPokemon into the URL path.
        // This retrieves detailed information about the Pokémon with the given number.
        @Path("numberPokemon") numberPokemon: Int
    ): com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
    // The function returns a Pokemon object containing detailed data about a specific Pokémon.
}