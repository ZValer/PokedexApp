package com.example.kotlin.mypokedexapp.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.framework.adapters.viewholders.PokemonViewHolder
import com.example.kotlin.mypokedexapp.databinding.ItemPokemonBinding

// PokemonAdapter is the adapter class for RecyclerView.
// It is responsible for providing the data to be displayed in each item of the RecyclerView and creating the ViewHolder for each item.
class PokemonAdapter: RecyclerView.Adapter<PokemonViewHolder>() {

    // A list to hold the data that will be displayed in the RecyclerView.
    var data: ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase> = ArrayList()

    // A reference to the context where this adapter is being used (i.e., the activity or fragment).
    lateinit var context: Context

    // This function is the constructor for the adapter, allowing the data and context to be passed in.
    // It sets the data for the adapter and initializes the context.
    fun PokemonAdapter(basicData: ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase>, context: Context) {
        this.data = basicData
        this.context = context
    }

    // This method binds the data to the ViewHolder at a specific position in the list.
    // It passes the individual PokemonBase item and context to the ViewHolder's bind method.
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        // Get the data item at the given position
        val item = data[position]
        // Call the bind function to display the data in the ViewHolder
        holder.bind(item, context)
    }

    // This method is called when RecyclerView needs a new ViewHolder to display an item.
    // It inflates the item layout and creates a new PokemonViewHolder to hold the views for that item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        // Inflate the layout for each RecyclerView item and create a binding object
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Return a new ViewHolder with the binding
        return PokemonViewHolder(binding)
    }

    // This method returns the total number of items in the data list.
    override fun getItemCount(): Int {
        return data.size
    }
}

