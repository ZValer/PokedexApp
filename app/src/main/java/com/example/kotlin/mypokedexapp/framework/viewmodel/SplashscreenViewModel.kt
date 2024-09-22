package com.example.kotlin.mypokedexapp.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.mypokedexapp.utilities.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// Parte de ViewModel y maneja la lógica de la pantalla de inicio.
// Permite que la UI observe el estado de carga de la pantalla de inicio.
class SplashscreenViewModel : ViewModel() {
    // MutableLiveData que indica si la carga ha finalizado.
    val finishedLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        // Establece finishedLoading como false para indicar que la carga está en progreso.
        finishedLoading.postValue(false)

        // Inicia una corutina en el scope del ViewModel para realizar operaciones asíncronas.
        viewModelScope.launch {
            // Espera durante la duración especificada para la pantalla de inicio.
            delay(Constants.SPLASHCREEN_DURATION)
            // Establece finishedLoading como true para indicar que la carga ha finalizado.
            finishedLoading.postValue(true)
        }
    }
}
