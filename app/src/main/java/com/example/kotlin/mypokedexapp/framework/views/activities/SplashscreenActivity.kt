package com.example.kotlin.mypokedexapp.framework.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin.mypokedexapp.databinding.ActivitySplashscreenBinding
import com.example.kotlin.mypokedexapp.framework.viewmodel.SplashscreenViewModel

class SplashscreenActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding //layout de la actividad
    private val viewModel: SplashscreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding() //Llama al método initializeBinding después definido

        viewModel.onCreate()

        // Inicializa los observadores que escuchan cambios en el ViewModel
        initializeObservers()
    }

    // Método para inicializar el binding, que infla el layout y lo enlaza con la actividad
    private fun initializeBinding(){
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root) // Asigna la vista raíz al contenido de la actividad
    }

    // Método que inicializa los observadores de LiveData, observando cuando el ViewModel ha terminado de cargar
    private fun initializeObservers(){
        // Observa la propiedad 'finishedLoading' del ViewModel
        viewModel.finishedLoading.observe(this, Observer { finishedLoading ->
            // Si 'finishedLoading' es verdadero, llama a 'passViewGoToMain'
            if (finishedLoading) {
                passViewGoToMain()
            }
        })
    }

    // Método para cambiar a la actividad principal (MainActivity)
    private fun passViewGoToMain() {
        // Crea un Intent para navegar a 'MainActivity'
        var intent: Intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP) // Asegura que solo haya una instancia de MainActivity
        startActivity(intent) // Inicia la actividad
        finish() // Finaliza la actividad actual para que no quede en el stack de navegación
    }
}
