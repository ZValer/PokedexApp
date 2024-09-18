package com.example.kotlin.pokedexapp2.data.network

import com.example.kotlin.pokedexapp2.data.network.model.pokemon.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Interfaz que define los endpoints de la API de Pokémon utilizando Retrofit.
// Es responsable de realizar las solicitudes HTTP a la API.

interface PokemonAPIService {

    // Solicitud GET para obtener una lista de Pokémon con un límite especificado.
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int
    ): com.example.kotlin.pokedexapp2.data.network.model.PokedexObject

    // Solicitud GET para obtener un objeto Pokemon con la info detallada
    // de un Pokémon específico por su número.
    // El 'numberPokemon' es el ID del Pokémon en la Pokédex.
    @GET("pokemon/{numberPokemon}")
    suspend fun getPokemonInfo(
        @Path("numberPokemon") numberPokemon: Int
    ): Pokemon
}
