package com.example.kotlin.mypokedexapp.framework.views.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.mypokedexapp.databinding.FragmentTareasBinding
import com.example.kotlin.mypokedexapp.framework.adapters.SuperHeroAdapter
import com.example.kotlin.mypokedexapp.framework.views.activities.MainActivity
import com.example.kotlin.mypokedexapp.utilities.Constants
import com.example.kotlin.mypokedexapp.data.network.model.SuperHeroProvider

class TareasFragment : Fragment() {
    private var _binding: FragmentTareasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar el layout y obtener el binding
        _binding = FragmentTareasBinding.inflate(inflater, container, false)

        // Configurar un listener para el botón de búsqueda
        binding.btnBusqueda.setOnClickListener {
            // Llama a 'selectMenuOption' en 'MainActivity' para cambiar al fragmento de búsqueda
            (activity as? MainActivity)?.selectMenuOption(Constants.MENU_SEARCH)
        }

        // Inicializar el RecyclerView
        initRecyclerView()

        // Retorna la vista raíz del binding
        return binding.root
    }

    // Método para inicializar el RecyclerView
    private fun initRecyclerView() {
        binding.recyclerSuperHero.layoutManager = LinearLayoutManager(context)
        binding.recyclerSuperHero.adapter = SuperHeroAdapter(SuperHeroProvider.superheroList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
