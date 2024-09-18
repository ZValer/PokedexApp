package com.example.kotlin.pokedexapp2.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.pokedexapp2.R
import com.example.kotlin.pokedexapp2.data.network.model.PokemonBase
import com.example.kotlin.pokedexapp2.databinding.FragmentPokedexBinding
import com.example.kotlin.pokedexapp2.framework.adapters.PokemonAdapter
import com.example.kotlin.pokedexapp2.framework.viewmodel.PokedexViewModel

// Fragmento que muestra una lista de Pokémon utilizando un RecyclerView.
// Observa los cambios en el ViewModel y actualiza la lista de Pokémon
// cuando se obtienen los datos.

class PokedexFragment: Fragment() {

    // Variable de enlace a la vista para acceder a los elementos de UI definidos en el layout.
    private var _binding: FragmentPokedexBinding? = null

    // Esta propiedad solo es válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    // Instancia del ViewModel que se utilizará para obtener los datos.
    private lateinit var viewModel: PokedexViewModel

    // RecyclerView para mostrar la lista de Pokémon.
    private lateinit var recyclerView: RecyclerView

    // Variables de nuestro MainActivity el adapter y el ArrayList para los datos
    private val adapter : PokemonAdapter = PokemonAdapter()
    private lateinit var data: ArrayList<PokemonBase>

    // Método que se llama para crear la vista del fragmento.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicializa el ViewModel para obtener los datos de Pokémon.
        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]

        // Infla el layout del fragmento y lo asigna a la variable de binding.
        _binding = FragmentPokedexBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inicializa la lista de datos vacía.
        data = ArrayList()

        // Inicializa los componentes de la UI y los observadores.
        initializeComponents(root)
        initializeObservers()

        // Llama al ViewModel para obtener la lista de Pokémon.
        viewModel.getPokemonList()

        // Devuelve la vista raíz del fragmento.
        return root
    }

    // Método que se llama cuando la vista del fragmento se destruye.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null  // Libera el binding para evitar fugas de memoria.
    }

    // Inicializa los componentes del RecyclerView dentro de la vista raíz.
    private fun initializeComponents(root: View) {
        recyclerView = root.findViewById(R.id.RVPokemon)  // Encuentra el RecyclerView en el layout.
    }

    // Configura los observadores para escuchar los cambios en los datos del ViewModel.
    private fun initializeObservers() {
        // Observa el LiveData del ViewModel para actualizar el RecyclerView cuando se obtenga la lista de Pokémon.
        viewModel.pokedexObjectLiveData.observe(viewLifecycleOwner) { pokedexObject ->
            setUpRecyclerView(pokedexObject.results)  // Actualiza el RecyclerView con la lista de resultados.
        }
    }

    // Configura el RecyclerView para mostrar la lista de Pokémon ahora grid.
    private fun setUpRecyclerView(dataForList:ArrayList<PokemonBase>){
        recyclerView.setHasFixedSize(true)
        /*val linearLayoutManager = LinearLayoutManager(
            requireContext(),        LinearLayoutManager.VERTICAL,        false)*/    val gridLayoutManager = GridLayoutManager(
            requireContext(),
            3,
            GridLayoutManager.VERTICAL,
            false    )
        recyclerView.layoutManager = gridLayoutManager
        adapter.PokemonAdapter(dataForList,requireContext())
        recyclerView.adapter = adapter
    }

}
