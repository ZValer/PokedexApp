package com.example.kotlin.pokedexapp2.framework.views.activities

import android.app.Activity
import android.os.Bundle
import com.example.kotlin.pokedexapp2.databinding.ActivityPokemonDetailBinding

class PokemonDetailActivity: Activity() {
    private lateinit var binding: ActivityPokemonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
    }

    private fun initializeBinding(){
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}