package com.example.kotlin.pokedexapp2.framework.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin.pokedexapp2.databinding.ActivitySplashscreenBinding
import com.example.kotlin.pokedexapp2.framework.viewmodel.SplashscreenViewModel

class SplashscreenActivity:AppCompatActivity() {

    private lateinit var binding: ActivitySplashscreenBinding
    private val viewModel: SplashscreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()

        viewModel.onCreate()

        initializeObservers()
    }

    private fun initializeBinding(){
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){
        viewModel.finishedLoading.observe(this, Observer {finishedLoading->
            if(finishedLoading){
                passViewGoToMain()
            }
        })
    }

    // Cambio automático del SplashscreenActivity al MainActivity.
    private fun passViewGoToMain() {
        // Intent para pasar a la actividad principal
        // this (SplashscreenActivity) -> MainActivity
        var intent: Intent = Intent(this, MainActivity::class.java)
        // Bandera para borrar el SplashscreenActivity y no regresar
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        // Cierra el SplashscreenActivity
        finish()
    }
}