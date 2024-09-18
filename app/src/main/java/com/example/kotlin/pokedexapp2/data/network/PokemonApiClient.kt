package com.example.kotlin.pokedexapp2.data.network

import com.example.kotlin.pokedexapp2.data.network.model.pokemon.Pokemon

// Clase que actúa como el cliente que utiliza el servicio API y se encarga
// de manejar las solicitudes y respuestas de la API.

class PokemonApiClient {

    // Almacena una instancia de `PokemonAPIService`
    private lateinit var api: PokemonAPIService

    // Obtiene una lista de Pokémon desde la API. Utiliza Retrofit a través
    // de `PokemonAPIService` para hacer la llamada a la API.
    suspend fun getPokemonList(limit: Int): com.example.kotlin.pokedexapp2.data.network.model.PokedexObject? {
        // Inicializa `api` con una instancia proporcionada por `NetworkModuleDI`.
        api = NetworkModuleDI()

        return try {
            // Realiza la solicitud a la API para obtener la lista de Pokémon.
            api.getPokemonList(limit)
        } catch (e: java.lang.Exception) {
            // Si ocurre una excepción, imprime el error y devuelve null.
            e.printStackTrace()
            null
        }
    }

    // Obtiene la información detallada de un Pokémon específico por su número.
    // Devuelve un objeto `Pokemon` o null si ocurre un error.
    suspend fun getPokemonInfo(numberPokemon: Int): Pokemon? {
        api = NetworkModuleDI()

        return try {
            // Realiza la solicitud a la API para obtener la información del Pokémon con el número especificado.
            api.getPokemonInfo(numberPokemon)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}
