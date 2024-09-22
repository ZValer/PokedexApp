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

    private lateinit var binding: ActivityMainBinding //layout donde se encuentra la navbar

    // Instancia de ViewModel para esta actividad
    private val viewModel: MainViewModel by viewModels()

    // Variable que mantiene el fragmento actualmente mostrado en la actividad
    private lateinit var currentFragment: Fragment

    // Variable para almacenar la opción de menú actual seleccionada
    private var currentMenuOption: String? = null

    // Método que se ejecuta cuando la actividad se crea
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding() // Inicializa el binding del layout

        // Inicializa los observadores (para LiveData u otros datos reactivos)
        initializeObservers()

        // Inicializa los listeners de las interacciones del usuario (por ejemplo, clics en botones)
        initializeListeners()

        // Establece el fragmento inicial en la actividad como el 'PokedexFragment'
        exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
    }

    // Método para inicializar el binding con el layout de la actividad
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)  // Infla el layout
        setContentView(binding.root)  // Establece el layout inflado como la vista principal
    }

    // Método reservado para inicializar observadores de datos (puedes agregar lógica más tarde)
    private fun initializeObservers() {
        // Aquí se podrían observar cambios en LiveData del ViewModel
    }

    // Método para cambiar el fragmento actual por uno nuevo
    private fun exchangeCurrentFragment(newFragment: Fragment, newMenuOption: String) {
        currentFragment = newFragment  // Actualiza el fragmento actual

        // Inicia una transacción para reemplazar el fragmento actual por el nuevo en el contenedor especificado
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, currentFragment)
            .commit()  // Confirma la transacción

        currentMenuOption = newMenuOption  // Actualiza la opción de menú actual
    }

    // Inicializa los listeners para las interacciones con la barra de navegación
    private fun initializeListeners() {
        // Listener para el botón "Pokedex", el id llPokedex viene del layout
        binding.appBarMain.llPokedex.setOnClickListener {
            selectMenuOption(Constants.MENU_POKEDEX)  // Cambia a la opción Pokedex
        }

        // Listener para el botón "Search", el id llSearch viene del layout
        binding.appBarMain.llSearch.setOnClickListener {
            selectMenuOption(Constants.MENU_SEARCH)  // Cambia a la opción Search
        }

        // Listener para el botón "Mis Tareas",  el id llMisTareas viene del layout
        binding.appBarMain.llMisTareas.setOnClickListener {
            selectMenuOption(Constants.MENU_TAREAS)  // Cambia a la opción "Mis Tareas"
        }
    }

    // Método para seleccionar una opción de menú
    public fun selectMenuOption(menuOption: String) {
        // Si la opción seleccionada es la misma que la actual, no hace nada
        if (menuOption == currentMenuOption) {
            return
        }

        // Cambia el fragmento según la opción seleccionada
        when (menuOption) {
            Constants.MENU_POKEDEX -> exchangeCurrentFragment(PokedexFragment(), Constants.MENU_POKEDEX)
            Constants.MENU_SEARCH -> exchangeCurrentFragment(SearchFragment(), Constants.MENU_SEARCH)
            Constants.MENU_TAREAS -> exchangeCurrentFragment(TareasFragment(), Constants.MENU_TAREAS)
        }
    }
}
