package com.example.kotlin.mypokedexapp.data.network

import com.example.kotlin.mypokedexapp.utilities.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// This object represents a dependency injection (DI) module for network-related components.
// It is responsible for setting up the Retrofit instance to handle API calls and configuring the network client.
object NetworkModuleDI {

    // GsonConverterFactory is used to convert JSON responses from the API into Kotlin objects.
    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()

    // OkHttpClient is a basic HTTP client that will be used by Retrofit to manage network requests.
    private val okHttpClient: OkHttpClient = OkHttpClient()

    // The invoke() function returns an instance of PokemonAPIService when called.
    // This is where the Retrofit object is created and configured to make network calls.
    operator fun invoke(): PokemonAPIService {
        return Retrofit.Builder()
            // The base URL for the API is retrieved from the Constants class.
            .baseUrl(Constants.BASE_URL)
            // The OkHttpClient is provided for network communication.
            .client(okHttpClient)
            // The GsonConverterFactory is used to convert the API's JSON responses into Kotlin objects.
            .addConverterFactory(gsonFactory)
            // Build the Retrofit instance and create the API service interface (PokemonAPIService).
            .build()
            .create(PokemonAPIService::class.java)
    }
}


/*
* object NetworkModuleDI:
* This is a singleton object in Kotlin, which means it only has one instance throughout the app.
* It's often used in dependency injection (DI) patterns to provide dependencies like network
* services across the app. In this case, it is responsible for providing an instance of
* PokemonAPIService, which is the service interface for making network requests (using Retrofit).
* */