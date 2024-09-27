package com.example.kotlin.mypokedexapp.framework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.data.network.model.SuperHero
import com.example.kotlin.mypokedexapp.framework.adapters.viewholders.SuperHeroViewHolder


// Recibe lista de Superheroes
class SuperHeroAdapter(private val superheroList:List<SuperHero>, private val onClickListener:(SuperHero) -> Unit) : RecyclerView.Adapter<SuperHeroViewHolder>() {

    //Pasarle el item o layout al view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))

    }

    // Pasa por cada uno de los items y nos devuelve el render de viewholder
    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superheroList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = superheroList.size
}