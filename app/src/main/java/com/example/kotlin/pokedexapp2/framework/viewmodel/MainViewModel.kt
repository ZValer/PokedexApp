package com.example.kotlin.pokedexapp2.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.pokedexapp2.data.network.model.PokedexObject
import com.example.kotlin.pokedexapp2.domain.PokemonListRequirement
import com.example.kotlin.pokedexapp2.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Gestiona la lógica de negocio y datos de la UI para la actividad principal.
// Obteniene la lista de Pokémon de la API utilizando corutinas y actualiza
// la interfaz de usuario a través de LiveData.

class MainViewModel: ViewModel() {

    // LiveData que contiene el objeto PokedexObject, que se utiliza para actualizar la UI con la lista de Pokémon.
    val pokedexObjectLiveData = MutableLiveData<PokedexObject>()

    // Llama a requirement para obtener la lista de Pokémon.
    private val pokemonListRequirement = PokemonListRequirement()

    // Obtiene la lista de Pokémon desde la API y la asigna al LiveData para
    // actualizar la UI.
    fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            val result: PokedexObject? = pokemonListRequirement(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())

            // Cambia al hilo principal para actualizar el LiveData con los resultados obtenidos.
            CoroutineScope(Dispatchers.Main).launch {
                pokedexObjectLiveData.postValue(result)
            }
        }
    }
}
