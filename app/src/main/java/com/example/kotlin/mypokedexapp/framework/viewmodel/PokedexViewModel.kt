package com.example.kotlin.mypokedexapp.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.mypokedexapp.data.network.model.PokedexObject
import com.example.kotlin.mypokedexapp.domain.PokemonListRequirement
import com.example.kotlin.mypokedexapp.utilities.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// PokedexViewModel maneja los datos para MainActivity y se comunica con la capa de dominio
// para obtener la lista de Pokémon.
// Extiende ViewModel, lo que le permite sobrevivir a los cambios de configuración y
// mantener datos a lo largo del ciclo de vida de la aplicación.
class PokedexViewModel : ViewModel() {

    // MutableLiveData que contiene los datos del objeto PokedexObject.
    // Esto permite que la interfaz de usuario (por ejemplo, MainActivity) observe los datos
    // y actualice la pantalla cuando los datos cambien.
    val pokedexObjectLiveData = MutableLiveData<PokedexObject>()

    // El caso de uso que contiene la lógica para obtener la lista de Pokémon.
    private val pokemonListRequirement = PokemonListRequirement()

    // Función para obtener la lista de Pokémon desde la API.
    // Ejecuta una corrutina para obtener los datos en un hilo en segundo plano y evitar
    // bloquear la interfaz de usuario.
    fun getPokemonList() {
        // Usando viewModelScope para lanzar una corrutina que se cancela automáticamente
        // cuando el ViewModel se destruye.
        viewModelScope.launch(Dispatchers.IO) {
            // Obtiene la lista de Pokémon de forma asíncrona. El resultado es un PokedexObject
            // que contiene detalles de Pokémon.
            val result: PokedexObject? = pokemonListRequirement(Constants.MAX_POKEMON_NUMBER)

            // Registra el número de Pokémon obtenidos para propósitos de depuración.
            Log.d("Salida", result?.count.toString())
            // Cambia al hilo principal para actualizar el LiveData, de manera que la interfaz
            // de usuario pueda actualizarse.
            CoroutineScope(Dispatchers.Main).launch {
                // Publica el resultado (PokedexObject) en LiveData, para que la interfaz de
                // usuario pueda observar y reaccionar a los cambios.
                pokedexObjectLiveData.postValue(result!!)
            }
        }
    }
}
