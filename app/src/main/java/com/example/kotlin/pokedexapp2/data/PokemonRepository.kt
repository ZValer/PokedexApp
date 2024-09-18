package com.example.kotlin.pokedexapp2.data

import com.example.kotlin.pokedexapp2.data.network.NetworkModuleDI
import com.example.kotlin.pokedexapp2.data.network.model.PokedexObject
import com.example.kotlin.pokedexapp2.data.network.PokemonAPIService
import com.example.kotlin.pokedexapp2.data.network.PokemonApiClient
import com.example.kotlin.pokedexapp2.data.network.model.pokemon.Pokemon

// Clase que actúa como el repositorio de datos para la aplicación.
// Interactuar con PokemonApiClient y sirve como punto central para
// gestionar datos.

class PokemonRepository() {

    private val apiPokemon = PokemonApiClient()

    // Llama al método correspondiente en PokemonApiClient y devuelve un PokedexObject.
    suspend fun getPokemonList(limit: Int): PokedexObject? = apiPokemon.getPokemonList(limit)

    // Llama al método correspondiente en PokemonApiClient y devuelve un objeto Pokemon.
    suspend fun getPokemonInfo(numberPokemon: Int): Pokemon? = apiPokemon.getPokemonInfo(numberPokemon)
}
