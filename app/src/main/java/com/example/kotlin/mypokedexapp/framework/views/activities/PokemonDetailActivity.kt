package com.example.kotlin.mypokedexapp.framework.views.activities

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.example.kotlin.mypokedexapp.databinding.ActivityPokemonDetailBinding
import com.example.kotlin.mypokedexapp.utilities.Constants

class PokemonDetailActivity: Activity() {

    private lateinit var binding: ActivityPokemonDetailBinding // layout de la actividad

    // Variable para almacenar la URL del Pokémon que se pasa mediante un Intent
    private var pokemonUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding() //Llama al método initializeBinding después definido

        manageIntent()
    }

    // Método que infla el layout y lo enlaza con la actividad
    private fun initializeBinding() {
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root) // Asigna el layout inflado como la vista principal de la actividad
    }

    // Método para gestionar el Intent y obtener los datos necesarios (URL del Pokémon)
    private fun manageIntent() {
        // Verifica si el Intent no es nulo
        if (intent != null) {
            // Obtiene la URL del Pokémon pasada en el Intent con la clave definida en 'Constants.URL_POKEMON'
            pokemonUrl = intent.getStringExtra(Constants.URL_POKEMON)

            // Imprime la URL obtenida en el logcat para propósitos de depuración
            Log.d("Salida", pokemonUrl.toString())
        }
    }
}
