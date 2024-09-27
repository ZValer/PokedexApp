package com.example.kotlin.mypokedexapp.framework.adapters.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.data.network.model.SuperHero

class SuperHeroViewHolder (val view: View): RecyclerView.ViewHolder(view){

    val superHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val realName = view.findViewById<TextView>(R.id.tvRealName)
    val publisher = view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivSuperHero)

    fun render(superHeroModel: SuperHero){
        superHero.text = superHeroModel.superhero
        realName.text = superHeroModel.realName
        publisher.text = superHeroModel.publisher
    }
}