package com.example.kotlin.mypokedexapp.framework.adapters.viewholders

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon
import com.example.kotlin.mypokedexapp.databinding.ItemPokemonBinding
import com.example.kotlin.mypokedexapp.domain.PokemonInfoRequirement
import com.example.kotlin.mypokedexapp.framework.views.activities.PokemonDetailActivity
import com.example.kotlin.mypokedexapp.utilities.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// PokemonViewHolder is a class that manages how individual Pokémon items are displayed in a RecyclerView.
// It holds the binding for each item in the list and provides methods to bind data to the views.
class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {

    // The bind function is called to associate a PokemonBase object with the view.
    // It sets the Pokémon's name and triggers loading its image.
    fun bind(item: com.example.kotlin.mypokedexapp.data.network.model.PokemonBase, context: Context) {
        // Setting the name of the Pokémon into the TextView
        binding.TVName.text = item.name

        // Fetching Pokémon information using its URL and loading its image
        getPokemonInfo(item.url, binding.IVPhoto, context)

        binding.llPokemon.setOnClickListener {
            passViewGoToPokemonDetail(item.url,context)
        }
    }

    // Private function to retrieve Pokémon information and display its image.
    // It extracts the Pokémon number from the URL and then fetches its data using a use case.
    private fun getPokemonInfo(url: String, imageView: ImageView, context: Context) {
        // URL is in the form "https://pokeapi.co/api/v2/pokemon/{pokemonNumber}/", so we remove the parts before and after the Pokémon number.
        var pokemonStringNumber: String = url.replace("https://pokeapi.co/api/v2/pokemon/", "")
        pokemonStringNumber = pokemonStringNumber.replace("/", "")

        // Convert the extracted Pokémon number from String to Int.
        val pokemonNumber: Int = Integer.parseInt(pokemonStringNumber)

        // Launching a coroutine in the IO thread to fetch data asynchronously without blocking the UI.
        CoroutineScope(Dispatchers.IO).launch {
            // Calling the use case to fetch detailed information about the Pokémon.
            val pokemonInfoRequirement = PokemonInfoRequirement()
            val result: com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon? = pokemonInfoRequirement(pokemonNumber)

            // Once the data is fetched, switching to the Main thread to update the UI.
            CoroutineScope(Dispatchers.Main).launch {
                // Extracting the URL of the Pokémon's official artwork image.
                val urlImage = result?.sprites?.other?.official_artwork?.front_default.toString()

                // RequestOptions for Glide to configure how the image should be loaded and displayed.
                val requestOptions = RequestOptions()
                    .centerCrop() // Center the image in the view.
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache the image to avoid reloading it multiple times.
                    .fitCenter() // Fit the image into the ImageView's dimensions.
                    .priority(Priority.HIGH) // Give high priority to this image loading.

                // Using Glide to load the Pokémon's image into the ImageView.
                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }
    }

    private fun passViewGoToPokemonDetail(url: String,context:Context){
        var intent: Intent = Intent(context, PokemonDetailActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        context.startActivity(intent)
        intent.putExtra(Constants.URL_POKEMON,url)
    }
}
