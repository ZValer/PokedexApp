package com.example.kotlin.pokedexapp2.framework.views

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.pokedexapp2.framework.adapters.PokemonAdapter
import com.example.kotlin.pokedexapp2.databinding.ActivityMainBinding
import com.example.kotlin.pokedexapp2.framework.viewmodel.MainViewModel
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.pokedexapp2.data.network.model.PokemonBase

// Actividad principal de la aplicación.
// Inicializa la vista, observa los datos del ViewModel y configurar el
// RecyclerView para mostrar la lista de Pokémon.

class MainActivity: AppCompatActivity() {

    // Enlaza los elementos de la interfaz con el layout correspondiente.
    private lateinit var binding: ActivityMainBinding

    // Adaptador que gestiona la lista de Pokémon para el RecyclerView.
    private val adapter : PokemonAdapter = PokemonAdapter()

    // Lista de datos que contendrá los Pokémon.
    private lateinit var data: ArrayList<PokemonBase>

    // Instancia del ViewModel
    private val viewModel: MainViewModel by viewModels()

    // Función que se ejecuta cuando la actividad es creada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa la vinculación de la vista (binding) y los observadores de datos.
        initializeBinding()
        initializeObservers()

        // Llama al ViewModel para obtener la lista de Pokémon.
        viewModel.getPokemonList()
    }

    // Función que inicializa el objeto binding para vincular la vista con el layout.
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  // Establece el layout inflado como la vista principal.
    }

    // Configura el RecyclerView para mostrar la lista de Pokémon en la interfaz de usuario.
    private fun setUpRecyclerView(dataForList: ArrayList<PokemonBase>) {
        binding.RVPokemon.setHasFixedSize(true)  // Fija el tamaño del RecyclerView para optimizar el rendimiento.

        // Configura el layout del RecyclerView en orientación vertical.
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        // Asigna el layout manager y el adaptador al RecyclerView.
        binding.RVPokemon.layoutManager = linearLayoutManager
        adapter.PokemonAdapter(dataForList, this)
        binding.RVPokemon.adapter = adapter
    }

    // Inicializa los observadores para escuchar cambios en el LiveData del ViewModel.
    private fun initializeObservers() {
        // Observa el LiveData del ViewModel para actualizar el RecyclerView cuando se reciba la lista de Pokémon.
        viewModel.pokedexObjectLiveData.observe(this) { pokedexObject ->
            setUpRecyclerView(pokedexObject.results)  // Actualiza el RecyclerView con la lista de resultados.
        }
    }
}
