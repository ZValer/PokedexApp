package com.example.kotlin.mypokedexapp.framework.views.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.mypokedexapp.databinding.FragmentSearchBinding
import com.example.kotlin.mypokedexapp.framework.viewmodel.SearchViewModel
import com.example.kotlin.mypokedexapp.framework.views.activities.MainActivity
import com.example.kotlin.mypokedexapp.utilities.Constants

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null //layout fragment_search.xml
    private val binding get() = _binding!! // Propiedad para acceder al binding de forma segura
    private lateinit var viewModel: SearchViewModel // Declaración del ViewModel

    // Método que se llama para crear la vista del fragmento
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, // Contenedor en el que se coloca la vista
        savedInstanceState: Bundle? // Estado guardado
    ): View {
        // Inicialización del ViewModel usando el proveedor de ViewModels
        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        // Inflar el layout y obtener el binding
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root // Vista raíz del fragmento

        // Establecer el listener para el botón "Mis tareas"
        binding.btnMisTareas.setOnClickListener {
            // Llamar al método de MainActivity para cambiar el fragmento
            (activity as? MainActivity)?.selectMenuOption(Constants.MENU_TAREAS)
        }

        return root // Retornar la vista raíz
    }

    // Método que se llama cuando la vista del fragmento se destruye
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Limpiar el binding para evitar fugas de memoria
    }
}
