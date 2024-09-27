package com.example.kotlin.mypokedexapp.framework.adapters.viewholders

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.mypokedexapp.data.network.model.SuperHero
import com.example.kotlin.mypokedexapp.databinding.ItemSuperheroBinding

class SuperHeroViewHolder (val view: View): RecyclerView.ViewHolder(view){
    val binding = ItemSuperheroBinding.bind(view)

    fun render(superHeroModel: SuperHero){
        binding.tvSuperHeroName.text = superHeroModel.superhero
        binding.tvRealName.text = superHeroModel.realName
        binding.tvPublisher.text = superHeroModel.publisher
        Glide.with(binding.ivSuperHero.context).load(superHeroModel.photo).into(binding.ivSuperHero)

        // Click en la imagen para desplegar nombre real
        binding.ivSuperHero.setOnClickListener {
            Toast.makeText(
                binding.ivSuperHero.context,
                superHeroModel.realName,
                Toast.LENGTH_SHORT
            ).show()
        }

        // Click en el item para desplegar nombre
        itemView.setOnClickListener {Toast.makeText(
            binding.ivSuperHero.context,
            superHeroModel.superhero,
            Toast.LENGTH_SHORT
        ).show() }
    }
}