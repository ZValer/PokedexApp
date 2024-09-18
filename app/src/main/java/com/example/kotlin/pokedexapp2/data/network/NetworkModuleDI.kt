package com.example.kotlin.pokedexapp2.data.network

import com.example.kotlin.pokedexapp2.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objeto singleton que actúa como un módulo de inyección de dependencias
// para la configuración de red. Configura y proporciona instancias de
// Retrofit y OkHttpClient para hacer solicitudes HTTP a la API de Pokémon.

object NetworkModuleDI {

    // Convertidor de JSON a objetos Kotlin utilizando Gson.
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    // Cliente HTTP que maneja las conexiones, puede ser configurado para
    // manejar caché, autenticación, etc.
    private val okHttpClient: OkHttpClient = OkHttpClient()

    // Sobrecarga del operador 'invoke', que permite que este objeto sea
    // llamado como si fuera una función. Este método devuelve una instancia
    // de `PokemonAPIService` con Retrofit.
    operator fun invoke(): PokemonAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)  // Define la URL base de la API
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()  // Crea la instancia de Retrofit
            // Asocia la interfaz `PokemonAPIService` con esta instancia de Retrofit
            .create(PokemonAPIService::class.java)
    }
}
