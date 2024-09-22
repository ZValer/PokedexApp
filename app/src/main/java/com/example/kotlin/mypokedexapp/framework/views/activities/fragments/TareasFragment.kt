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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_tareas, container, false)
        view.findViewById<Button>(R.id.btn_busqueda).setOnClickListener {
            (activity as? MainActivity)?.selectMenuOption(Constants.MENU_SEARCH)
        }
        return view
    }
}
