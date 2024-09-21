package com.example.kotlin.mypokedexapp.data

import com.example.kotlin.mypokedexapp.data.network.NetworkModuleDI
import com.example.kotlin.mypokedexapp.data.network.model.PokedexObject
import com.example.kotlin.mypokedexapp.data.network.PokemonAPIService
import com.example.kotlin.mypokedexapp.data.network.PokemonApiClient
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon

// The PokemonRepository class acts as a middleman between the ViewModel (or other parts of the app) and the data source (API).
// It manages fetching the data from the API through the PokemonApiClient and can be easily extended to include caching or other data sources.
class PokemonRepository() {

    // A reference to the PokemonApiClient, which is responsible for making network requests to the Pokemon API.
    private val apiPokemon = PokemonApiClient()

    // suspend function to fetch a list of Pokémon with the given limit.
    // It delegates the API request to the PokemonApiClient and returns a PokedexObject, or null if an exception occurs.
    suspend fun getPokemonList(limit: Int): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject? =
        apiPokemon.getPokemonList(limit)

    // suspend function to fetch information about a specific Pokémon by its number.
    // It delegates the API request to the PokemonApiClient and returns a Pokemon object, or null if an exception occurs.
    suspend fun getPokemonInfo(numberPokemon: Int): com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon? =
        apiPokemon.getPokemonInfo(numberPokemon)
}
