package com.example.kotlin.mypokedexapp.data.network

import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon

// Clase cliente que se comunica con la API de Pokémon a través de la interfaz PokemonAPIService.
// Actúa como una abstracción para gestionar las llamadas a la API y maneja cualquier excepción que pueda ocurrir durante estas llamadas.
class PokemonApiClient {

    // Referencia a PokemonAPIService, que se usa para realizar solicitudes de red.
    // Se usa el modificador lateinit porque el servicio de la API se inicializará más tarde.
    private lateinit var api: PokemonAPIService

    // Función suspend para obtener una lista de Pokémon con el límite especificado.
    // Devuelve un PokedexObject o null si ocurre una excepción.
    suspend fun getPokemonList(limit: Int): com.example.kotlin.mypokedexapp.data.network.model.PokedexObject? {
        // Inicializa el PokemonAPIService utilizando el NetworkModuleDI, que configura la instancia de Retrofit.
        api = NetworkModuleDI()

        return try {
            // Llamar al método del servicio de la API para obtener la lista de Pokémon.
            api.getPokemonList(limit)
        } catch (e: java.lang.Exception) {
            // Si ocurre una excepción (por ejemplo, error de red), imprime el stack trace y devuelve null.
            e.printStackTrace()
            null
        }
    }

    // Función suspend para obtener info detallada sobre un Pokémon específico por su número.
    // Devuelve un objeto Pokemon o null si ocurre una excepción.
    suspend fun getPokemonInfo(numberPokemon: Int): com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon? {
        // Inicializa el PokemonAPIService utilizando el NetworkModuleDI, que configura la instancia de Retrofit.
        api = NetworkModuleDI()

        return try {
            // Llamar al método del servicio de la API para obtener información sobre un Pokémon específico.
            api.getPokemonInfo(numberPokemon)
        } catch (e: java.lang.Exception) {
            // Si ocurre una excepción (por ejemplo, error de red), imprime el stack trace y devuelve null.
            e.printStackTrace()
            null
        }
    }
}
