package com.example.kotlin.pokedexapp2.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.pokedexapp2.data.network.model.PokemonBase
import com.example.kotlin.pokedexapp2.framework.adapters.viewholders.PokemonViewHolder
import com.example.kotlin.pokedexapp2.databinding.ItemPokemonBinding

// Clase Adapter para el RecyclerView que maneja la visualización de una
// lista de Pokémon. Se encarga de proporcionar los datos a los ViewHolders
// y crear las vistas necesarias para cada item en el RecyclerView.

class PokemonAdapter: RecyclerView.Adapter<PokemonViewHolder>() {

    // Lista de datos que contendrá los Pokémon Base (del modelo) a mostrar
    var data: ArrayList<PokemonBase> = ArrayList()

    lateinit var context: Context

    // Constructor que recibe la lista de Pokémon y el contexto
    fun PokemonAdapter(basicData: ArrayList<PokemonBase>, context: Context) {
        this.data = basicData  // Asigna los datos
        this.context = context  // Asigna el contexto
    }

    // Enlaza los datos con el ViewHolder para una posición específica
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = data[position]  // Obtiene el Pokémon de la posición actual
        holder.bind(item, context)  // Enlaza los datos del Pokémon con el ViewHolder
    }

    // Función que crea un nuevo ViewHolder cuando es necesario
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        // Infla el layout de cada item (fila) utilizando el layout definido en `ItemPokemonBinding`
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)  // Crea un nuevo ViewHolder
    }

    // Devuelve el número total de elementos en la lista
    override fun getItemCount(): Int {
        return data.size
    }
}
