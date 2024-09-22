package com.example.kotlin.mypokedexapp.data.network

import com.example.kotlin.mypokedexapp.utilities.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Este objeto representa un módulo de inyección de dependencias (DI) para componentes
// relacionados con la red.
// Es responsable de configurar la instancia de Retrofit para manejar las llamadas a la API
// y de configurar el cliente de red.
object NetworkModuleDI {

    // GsonConverterFactory se utiliza para convertir las respuestas JSON de la API en objetos
    // de Kotlin.
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    // OkHttpClient es un cliente HTTP básico que será utilizado por Retrofit para gestionar
    // las solicitudes de red.
    private val okHttpClient: OkHttpClient = OkHttpClient()

    // La función invoke() devuelve una instancia de PokemonAPIService cuando se llama.
    // Aquí es donde se crea y configura el objeto Retrofit para realizar llamadas de red.
    operator fun invoke(): PokemonAPIService {
        return Retrofit.Builder()
            // La URL base para la API se recupera de la clase Constants.
            .baseUrl(Constants.BASE_URL)
            // Se proporciona OkHttpClient para la comunicación de red.
            .client(okHttpClient)
            // GsonConverterFactory se utiliza para convertir las respuestas JSON de la API
            // en objetos de Kotlin.
            .addConverterFactory(gsonFactory)
            // Se construye la instancia de Retrofit y se crea la interfaz del servicio API
            // (PokemonAPIService).
            .build()
            .create(PokemonAPIService::class.java)
    }
}

/*
* object NetworkModuleDI:
* Este es un objeto singleton en Kotlin, lo que significa que solo tiene una instancia en toda
* la aplicación. A menudo se utiliza en patrones de inyección de dependencias (DI) para
* proporcionar dependencias como servicios de red en toda la aplicación.
* En este caso, es responsable de proporcionar una instancia de PokemonAPIService,
* que es la interfaz del servicio para realizar solicitudes de red (usando Retrofit).
*/
