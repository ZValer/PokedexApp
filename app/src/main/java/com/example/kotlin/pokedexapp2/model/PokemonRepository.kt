package com.example.kotlin.pokedexapp2.model

import com.example.kotlin.pokedexapp2.model.pokemon.Pokemon

class PokemonRepository (){
    private lateinit var api: PokemonAPIService
    suspend fun getPokemonList(limit:Int): PokedexObject?{
        api = NetworkModuleDI()
        return try{
            api.getPokemonList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getPokemonInfo(numberPokemon:Int): com.example.kotlin.pokedexapp2.model.pokemon.Pokemon? {
        api = NetworkModuleDI()
        return try{
            api.getPokemonInfo(numberPokemon)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}