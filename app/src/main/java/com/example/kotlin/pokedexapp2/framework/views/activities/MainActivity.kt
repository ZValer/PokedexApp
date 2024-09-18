package com.example.kotlin.pokedexapp2.framework.views.activities

import android.os.Bundle
import com.example.kotlin.pokedexapp2.databinding.ActivityMainBinding
import com.example.kotlin.pokedexapp2.framework.viewmodel.MainViewModel
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin.pokedexapp2.R
import com.example.kotlin.pokedexapp2.framework.views.fragments.PokedexFragment

// Actividad principal de la aplicación.
// Inicializa la vista, observa los datos del ViewModel y configurar el
// RecyclerView para mostrar la lista de Pokémon.

class MainActivity: AppCompatActivity() {

    // Enlaza los elementos de la interfaz con el layout correspondiente.
    private lateinit var binding: ActivityMainBinding

    // Instancia del ViewModel
    private val viewModel: MainViewModel by viewModels()

    private lateinit var currentFragment: Fragment

    // Función que se ejecuta cuando la actividad es creada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa la vinculación de la vista (binding) y los observadores de datos.
        initializeBinding()
        initializeObservers()

        exchangeCurrentFragment(PokedexFragment())
    }

    // Función que inicializa el objeto binding para vincular la vista con el layout.
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  // Establece el layout inflado como la vista principal.
    }

    // Inicializa los observadores para escuchar cambios en el LiveData del ViewModel.
    private fun initializeObservers(){

    }

    private fun exchangeCurrentFragment(newFragment:Fragment){
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main,currentFragment)
            .commit()
    }
}
