package com.example.kotlin.mypokedexapp.framework.views.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.databinding.FragmentPokedexBinding
import com.example.kotlin.mypokedexapp.framework.adapters.PokemonAdapter
import com.example.kotlin.mypokedexapp.framework.viewmodel.PokedexViewModel

class PokedexFragment: Fragment() {
    private var _binding: FragmentPokedexBinding? = null // layout del fragment_pokedex.xml

    // Propiedad para acceder al binding de manera segura solo entre onCreateView y onDestroyView
    private val binding get() = _binding!!

    private lateinit var viewModel: PokedexViewModel // ViewModel para manejar la lógica del fragmento
    private lateinit var recyclerView: RecyclerView // RecyclerView para mostrar la lista de Pokémon
    private val adapter: PokemonAdapter = PokemonAdapter() // Adapter para gestionar la lista en el RecyclerView
    private lateinit var data: ArrayList<PokemonBase> // Lista que contiene los datos de Pokémon

    override fun onCreateView(
        inflater: LayoutInflater, // Inflador de vistas
        container: ViewGroup?, // Contenedor para el fragmento
        savedInstanceState: Bundle? // Estado guardado del fragmento
    ): View {
        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]

        // Inflar el layout y obtener el binding
        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        val root: View = binding.root // Vista raíz del fragmento

        // Inicializar la lista de datos de Pokémon
        data = ArrayList()

        // Llamada a métodos para inicializar componentes y observar cambios en el ViewModel
        initializeComponents(root) // Inicializa la interfaz gráfica
        initializeObservers() // Inicializa los observadores para el LiveData del ViewModel
        viewModel.getPokemonList() // Solicita al ViewModel la lista de Pokémon

        return root // Retorna la vista raíz
    }

    // Método que se llama cuando la vista se destruye
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Limpia el binding para evitar fugas de memoria
    }

    // Método para inicializar los componentes de la interfaz
    private fun initializeComponents(root: View) {
        recyclerView = root.findViewById(R.id.RVPokemon) // Vincula el RecyclerView
        // RVPokemon es el ID del RecyclerView en el layout fragment_pokedex.xml
    }

    // Método para inicializar los observadores de LiveData en el ViewModel
    private fun initializeObservers() {
        // Se observa el LiveData del ViewModel para actualizar la lista cuando haya cambios
        viewModel.pokedexObjectLiveData.observe(viewLifecycleOwner) { pokedexObject ->
            setUpRecyclerView(pokedexObject.results) // Configura el RecyclerView con los resultados
        }
    }

    // Método para configurar el RecyclerView
    private fun setUpRecyclerView(dataForList: ArrayList<PokemonBase>) {
        recyclerView.setHasFixedSize(true) // Fija el tamaño del RecyclerView para optimización

        // Opción comentada para un LinearLayout (lista vertical)
        /*val linearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false)
        recyclerView.layoutManager = linearLayoutManager*/

        // Configura el RecyclerView con un GridLayout (rejilla de 3 columnas)
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            3, // Número de columnas en la rejilla
            GridLayoutManager.VERTICAL, // Orientación vertical
            false
        )
        recyclerView.layoutManager = gridLayoutManager // Establece el layout manager

        // Configura el adapter para gestionar los datos
        adapter.PokemonAdapter(dataForList, requireContext())
        recyclerView.adapter = adapter // Vincula el adapter al RecyclerView
    }
}
