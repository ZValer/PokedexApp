package com.example.kotlin.pokedexapp2.views

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.pokedexapp2.utils.Constants
import com.example.kotlin.pokedexapp2.adapters.PokemonAdapter
import com.example.kotlin.pokedexapp2.databinding.ActivityMainBinding
import com.example.kotlin.pokedexapp2.model.PokedexObject
import com.example.kotlin.pokedexapp2.model.PokemonBase
import com.example.kotlin.pokedexapp2.model.PokemonRepository
import com.example.kotlin.pokedexapp2.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data:ArrayList<PokemonBase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getPokemonList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){
        viewModel.pokedexObjectLiveData.observe(this){ poxedexObject ->
            setUpRecyclerView(poxedexObject.results)
        }
    }

    private fun getPokemonList(){
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonRepository = PokemonRepository()
            val result: PokedexObject? = pokemonRepository.getPokemonList(Constants.MAX_POKEMON_NUMBER)
            Log.d("Salida", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                setUpRecyclerView(result?.results!!)
            }
        }
    }

    private fun setUpRecyclerView(dataForList:ArrayList<PokemonBase>){
        binding.RVPokemon.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVPokemon.layoutManager = linearLayoutManager
        adapter.PokemonAdapter(dataForList,this)
        binding.RVPokemon.adapter = adapter
    }


}

