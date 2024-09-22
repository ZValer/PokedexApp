package com.example.kotlin.mypokedexapp.data

import com.example.kotlin.mypokedexapp.data.network.NetworkModuleDI
import com.example.kotlin.mypokedexapp.data.network.model.PokedexObject
import com.example.kotlin.mypokedexapp.data.network.PokemonAPIService
import com.example.kotlin.mypokedexapp.data.network.PokemonApiClient
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon

// Intermediario entre el Requirement (u otras partes de la aplicación) y la fuente de datos (API).
// Gestiona la obtención de datos de la API a través del PokemonApiClient y puede ampliarse
// fácilmente para incluir almacenamiento en caché u otras fuentes de datos.
class PokemonRepository() {
    // PokemonApiClient es responsable de realizar solicitudes de red a la API de Pokémon.
    private val apiPokemon = PokemonApiClient()

    // Función suspend para obtener una lista de Pokémon con el límite dado.
    // Delegar la solicitud a la API al PokemonApiClient(Modelo-Data) y devolver un PokedexObject, o null.
    suspend fun getPokemonList(limit: Int): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject? =
        apiPokemon.getPokemonList(limit)

    // Función suspend para obtener info sobre un Pokémon específico por su número.
    // Delegar la solicitud a la API al PokemonApiClient(Modelo-Data) y devolver un objeto Pokémon, o null.
    suspend fun getPokemonInfo(numberPokemon: Int): com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon? =
        apiPokemon.getPokemonInfo(numberPokemon)
}
