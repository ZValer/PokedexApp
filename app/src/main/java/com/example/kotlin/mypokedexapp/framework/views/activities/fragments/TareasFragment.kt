package com.example.kotlin.mypokedexapp.framework.views.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.framework.views.activities.MainActivity
import com.example.kotlin.mypokedexapp.utilities.Constants

class TareasFragment : Fragment() {

    // Método que se ejecuta para crear y mostrar la vista del fragmento
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, // Contenedor en el que se coloca la vista
        savedInstanceState: Bundle? // Estado guardado
    ): View? {
        // Inflar el layout 'fragment_tareas'
        val view = inflater.inflate(R.layout.fragment_tareas, container, false)

        // Configurar un listener para el botón de búsqueda dentro del fragmento
        view.findViewById<Button>(R.id.btn_busqueda).setOnClickListener {
            // Llama a 'selectMenuOption' en 'MainActivity' para cambiar al fragmento de búsqueda
            (activity as? MainActivity)?.selectMenuOption(Constants.MENU_SEARCH)
        }

        // Retorna la vista inflada para que el sistema la maneje
        return view
    }
}
