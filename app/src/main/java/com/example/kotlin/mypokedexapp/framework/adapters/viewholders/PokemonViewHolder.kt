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

// PokemonViewHolder es una clase que gestiona cómo se muestran los elementos individuales de
// Pokémon en un RecyclerView.
// Mantiene el binding para cada elemento en la lista y proporciona métodos para enlazar datos
// a las vistas.
class PokemonViewHolder(private val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {

    // La función bind asocia un objeto PokemonBase con la vista.
    // Establece el nombre del Pokémon y desencadena la carga de su imagen.
    fun bind(item: com.example.kotlin.mypokedexapp.data.network.model.PokemonBase, context: Context) {
        binding.TVName.text = item.name // Establecer el nombre del Pokémon en el TextView

        // Obtener información del Pokémon usando su URL y cargar su imagen
        getPokemonInfo(item.url, binding.IVPhoto, context)

        binding.llPokemon.setOnClickListener {
            passViewGoToPokemonDetail(item.url, context)
        }
    }

    // Función para recuperar info del Pokémon y mostrar su imagen.
    // Extrae el número del Pokémon de la URL y luego recupera sus datos usando un caso de uso.
    private fun getPokemonInfo(url: String, imageView: ImageView, context: Context) {
        // La URL está en la forma "https://pokeapi.co/api/v2/pokemon/{pokemonNumber}/", por lo que eliminamos las partes antes y después del número del Pokémon.
        var pokemonStringNumber: String = url.replace("https://pokeapi.co/api/v2/pokemon/", "")
        pokemonStringNumber = pokemonStringNumber.replace("/", "")

        // Convertir el número del Pokémon extraído de String a Int.
        val pokemonNumber: Int = Integer.parseInt(pokemonStringNumber)

        // Lanzar una coroutine en el hilo IO para obtener datos de forma asíncrona sin bloquear la UI.
        CoroutineScope(Dispatchers.IO).launch {
            // Llamar al caso de uso para obtener información detallada sobre el Pokémon.
            val pokemonInfoRequirement = PokemonInfoRequirement()
            val result: com.example.kotlin.mypokedexapp.data.network.model.pokemon.Pokemon? = pokemonInfoRequirement(pokemonNumber)

            // Una vez que se obtienen los datos, cambiar al hilo principal para actualizar la UI.
            CoroutineScope(Dispatchers.Main).launch {
                // Extraer la URL de la imagen oficial del Pokémon.
                val urlImage = result?.sprites?.other?.official_artwork?.front_default.toString()

                // RequestOptions para Glide para configurar cómo se debe cargar y mostrar la imagen.
                val requestOptions = RequestOptions()
                    .centerCrop() // Centrar la imagen en la vista.
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // Caché la imagen para evitar recargas múltiples.
                    .fitCenter() // Ajustar la imagen a las dimensiones del ImageView.
                    .priority(Priority.HIGH) // Dar alta prioridad a esta carga de imagen.

                // Usar Glide para cargar la imagen del Pokémon en el ImageView.
                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
        }
    }

    // Maneja la navegación a la actividad de detalles del Pokémon.
    // Recibe la URL del Pokémon y el contexto de la aplicación como parámetros.
    private fun passViewGoToPokemonDetail(url: String, context: Context) {
        // Crear un nuevo Intent para iniciar la actividad de detalles del Pokémon.
        var intent: Intent = Intent(context, PokemonDetailActivity::class.java)

        // Agregar la bandera FLAG_ACTIVITY_SINGLE_TOP para evitar crear una nueva instancia de la
        // actividad si ya está en la parte superior de la pila.
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

        // Iniciar la actividad de detalles del Pokémon utilizando el contexto proporcionado.
        context.startActivity(intent)

        // Pasar la URL del Pokémon como un extra en el Intent, lo que permite a la nueva actividad
        // acceder a esta información.
        intent.putExtra(Constants.URL_POKEMON, url)
    }

}
