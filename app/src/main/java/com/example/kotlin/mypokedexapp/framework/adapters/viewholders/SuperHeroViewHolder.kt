package com.example.kotlin.mypokedexapp.framework.adapters.viewholders

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.mypokedexapp.data.network.model.SuperHero
import com.example.kotlin.mypokedexapp.databinding.ItemSuperheroBinding

class SuperHeroViewHolder (val view: View): RecyclerView.ViewHolder(view){
    val binding = ItemSuperheroBinding.bind(view)

    fun render(superHeroModel: SuperHero, onClickListener:(SuperHero) -> Unit){
        binding.tvSuperHeroName.text = superHeroModel.superhero
        binding.tvRealName.text = superHeroModel.realName
        binding.tvPublisher.text = superHeroModel.publisher
        Glide.with(binding.ivSuperHero.context).load(superHeroModel.photo).into(binding.ivSuperHero)

        // Click en el item para mostrar el nombre de super heroe
        itemView.setOnClickListener { onClickListener(superHeroModel)}
    }
}