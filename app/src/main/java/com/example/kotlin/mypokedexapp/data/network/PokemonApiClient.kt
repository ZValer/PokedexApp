package com.example.kotlin.mypokedexapp.data.network

import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon

// PokemonApiClient is a client class that communicates with the Pokemon API through the PokemonAPIService interface.
// It acts as an abstraction to manage API calls and handles any exceptions that may occur during these calls.
class PokemonApiClient {

    // A reference to the PokemonAPIService, which is used to make network requests.
    // The lateinit modifier is used because the API service will be initialized later.
    private lateinit var api: PokemonAPIService

    // suspend function to fetch a list of Pokémon with the specified limit.
    // It returns a PokedexObject or null if an exception occurs.
    suspend fun getPokemonList(limit: Int): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject? {
        // Initialize the PokemonAPIService using the NetworkModuleDI, which sets up the Retrofit instance.
        api = NetworkModuleDI()

        return try {
            // Call the API service method to fetch the list of Pokémon.
            api.getPokemonList(limit)
        } catch (e: java.lang.Exception) {
            // If an exception occurs (e.g., network error), print the stack trace and return null.
            e.printStackTrace()
            null
        }
    }

    // suspend function to fetch detailed information about a specific Pokémon by its number.
    // It returns a Pokemon object or null if an exception occurs.
    suspend fun getPokemonInfo(numberPokemon: Int): com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon? {
        // Initialize the PokemonAPIService using the NetworkModuleDI, which sets up the Retrofit instance.
        api = NetworkModuleDI()

        return try {
            // Call the API service method to fetch information about a specific Pokémon.
            api.getPokemonInfo(numberPokemon)
        } catch (e: java.lang.Exception) {
            // If an exception occurs (e.g., network error), print the stack trace and return null.
            e.printStackTrace()
            null
        }
    }
}
