package com.example.kotlin.mypokedexapp.framework.views.activities

import android.os.Bundle
import com.example.kotlin.mypokedexapp.databinding.ActivityMainBinding
import com.example.kotlin.mypokedexapp.framework.viewmodel.MainViewModel
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.framework.views.activities.fragments.PokedexFragment
import com.example.kotlin.mypokedexapp.framework.views.activities.fragments.SearchFragment
import com.example.kotlin.mypokedexapp.framework.views.activities.fragments.TareasFragment
import com.example.kotlin.mypokedexapp.utilities.Constants

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private lateinit var currentFragment: Fragment

    private var currentMenuOption:String?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar el binding
        initializeBinding()

        // Inicializar los observadores (si los hay)
        initializeObservers()

        // Inicializar los listeners
        initializeListeners()

        // Establecer el fragmento inicial
        exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
    }

    // Inicializar el binding con ActivityMainBinding
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // Inicializar los observadores de LiveData u otros (puedes agregar lógica aquí más adelante)
    private fun initializeObservers(){

    }

    // Cambiar el fragmento actual por uno nuevo, si es necesario
    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption: String){
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, currentFragment)
            .commit()

        currentMenuOption = newMenuOption
    }

    // Inicializar los listeners para las opciones de la barra de navegación
    private fun initializeListeners() {
        binding.appBarMain.llPokedex.setOnClickListener {
            selectMenuOption(Constants.MENU_POKEDEX)
        }

        binding.appBarMain.llSearch.setOnClickListener {
            selectMenuOption(Constants.MENU_SEARCH)
        }

        // Nueva opción para "Mis Tareas"
        binding.appBarMain.llMisTareas.setOnClickListener {
            selectMenuOption(Constants.MENU_TAREAS)
        }
    }

    // Seleccionar la opción de menú basada en la constante pasada
    private fun selectMenuOption(menuOption: String) {
        // Evitar volver a cargar el mismo fragmento si ya está seleccionado
        if (menuOption == currentMenuOption) {
            return
        }

        // Cambiar el fragmento según la opción seleccionada
        when (menuOption) {
            Constants.MENU_POKEDEX -> exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
            Constants.MENU_SEARCH -> exchangeCurrentFragment(SearchFragment(), Constants.MENU_SEARCH)
            Constants.MENU_TAREAS -> exchangeCurrentFragment(TareasFragment(), Constants.MENU_TAREAS) // Navegar a "Mis Tareas"
        }
    }
}
