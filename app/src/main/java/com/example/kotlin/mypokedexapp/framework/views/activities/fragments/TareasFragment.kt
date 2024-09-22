package com.example.kotlin.mypokedexapp.framework.views.activities.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kotlin.mypokedexapp.R
import com.example.kotlin.mypokedexapp.framework.views.activities.fragments.SearchFragment

class TareasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout del fragmento
       val view = inflater.inflate(R.layout.fragment_tareas, container, false)
        view.findViewById<Button>(R.id.btn_busqueda).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, SearchFragment())
                .addToBackStack(null) // Esto permite volver al TareasFragment
                .commit()
        }
        return view
    }
}
