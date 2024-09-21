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

// MainViewModel handles the data for the MainActivity and interacts with the domain layer to fetch the Pokémon list.
// It extends ViewModel, which allows it to survive configuration changes and maintain data across the app's lifecycle.
class PokedexViewModel:ViewModel() {

    // MutableLiveData object that holds the PokedexObject data.
    // This allows the UI (e.g., MainActivity) to observe the data and update the screen when the data changes.
    val pokedexObjectLiveData = MutableLiveData<PokedexObject>()

    // The use case that contains the logic to fetch the Pokémon list.
    private val pokemonListRequirement = PokemonListRequirement()

    // Function to fetch the list of Pokémon from the API.
    // It runs a coroutine to fetch the data on a background thread to avoid blocking the UI.
    fun getPokemonList(){
        // Using viewModelScope to launch a coroutine that automatically cancels when the ViewModel is destroyed.
        viewModelScope.launch(Dispatchers.IO) {
            // Fetching the Pokémon list asynchronously. The result is a PokedexObject containing Pokémon details.
            val result: PokedexObject? = pokemonListRequirement(Constants.MAX_POKEMON_NUMBER)

            // Logging the number of Pokémon fetched for debugging purposes.
            Log.d("Salida", result?.count.toString())
            // Switching to the main thread to update the LiveData, so the UI can be updated.
            CoroutineScope(Dispatchers.Main).launch {
                // Posting the result (PokedexObject) to LiveData, so the UI can observe and respond to changes.
                pokedexObjectLiveData.postValue(result!!)
            }
        }    }
}