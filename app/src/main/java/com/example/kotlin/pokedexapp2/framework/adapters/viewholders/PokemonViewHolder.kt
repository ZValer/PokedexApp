package com.example.kotlin.pokedexapp2.framework.adapters.viewholders

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.pokedexapp2.data.network.model.PokemonBase
import com.example.kotlin.pokedexapp2.data.network.model.pokemon.Pokemon
import com.example.kotlin.pokedexapp2.databinding.ItemPokemonBinding
import com.example.kotlin.pokedexapp2.domain.PokemonInfoRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// ViewHolder para el RecyclerView que muestra los datos de cada Pokémon.
// Mantiene las referencias a las vistas de un item y asocia los datos.

class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {

    // Enlaza los datos de un objeto `PokemonBase` con las vistas.
    fun bind(item: PokemonBase, context: Context) {
        // Asigna el nombre del Pokémon al TextView
        binding.TVName.text = item.name
        // Obtiene la imagen del Pokémon y la asigna al ImageView
        getPokemonInfo(item.url, binding.IVPhoto, context)
    }

    // Obtiene la información detallada de un Pokémon mediante API.
    // Usa la URL del Pokémon para extraer su número, hace una solicitud de información y carga la imagen con Glide.
    private fun getPokemonInfo(url: String, imageView: ImageView, context: Context) {
        // Extrae el número del Pokémon de la URL
        var pokemonStringNumber: String = url.replace("https://pokeapi.co/api/v2/pokemon/", "")
        pokemonStringNumber = pokemonStringNumber.replace("/", "")
        val pokemonNumber: Int = Integer.parseInt(pokemonStringNumber)

        // Corutina para llamar el requirement para obtener la info del Pokémon
        CoroutineScope(Dispatchers.IO).launch {
            val pokemonInfoRequirement = PokemonInfoRequirement()
            val result: Pokemon? = pokemonInfoRequirement(pokemonNumber)

            // Vuelve al hilo principal para cargar la imagen en la interfaz
            CoroutineScope(Dispatchers.Main).launch {
                val urlImage = result?.sprites?.other?.official_artwork?.front_default.toString()

                // Usa Glide para cargar la imagen del Pokémon en el ImageView
                val requestOptions = RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }
    }
}
