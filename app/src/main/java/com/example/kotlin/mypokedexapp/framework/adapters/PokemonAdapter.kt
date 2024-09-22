package com.example.kotlin.mypokedexapp.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.mypokedexapp.data.network.model.PokemonBase
import com.example.kotlin.mypokedexapp.framework.adapters.viewholders.PokemonViewHolder
import com.example.kotlin.mypokedexapp.databinding.ItemPokemonBinding

// PokemonAdapter es la clase adaptadora para RecyclerView.
// Es responsable de proporcionar los datos que se mostrarán en cada elemento del
// RecyclerView y de crear el ViewHolder para cada elemento.
class PokemonAdapter: RecyclerView.Adapter<PokemonViewHolder>() {

    // Una lista para almacenar los datos que se mostrarán en el RecyclerView.
    var data: ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase> = ArrayList()

    // Una referencia al contexto donde se está utilizando este adaptador (es decir, la actividad o fragmento).
    lateinit var context: Context

    // Esta función es el constructor del adaptador, permitiendo pasar los datos y el contexto.
    // Establece los datos para el adaptador e inicializa el contexto.
    fun PokemonAdapter(basicData: ArrayList<com.example.kotlin.mypokedexapp.data.network.model.PokemonBase>, context: Context) {
        this.data = basicData
        this.context = context
    }

    // Este método enlaza los datos con el ViewHolder en una posición específica en la lista.
    // Pasa el elemento individual de PokemonBase y el contexto al método bind del ViewHolder.
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        // Obtiene el elemento de datos en la posición dada
        val item = data[position]
        // Llama a la función bind para mostrar los datos en el ViewHolder
        holder.bind(item, context)
    }

    // Este método se llama cuando el RecyclerView necesita un nuevo ViewHolder para mostrar
    // un elemento. Infla el layout del elemento y crea un nuevo PokemonViewHolder para
    // contener las vistas de ese elemento.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        // Infla el layout para cada elemento del RecyclerView y crea un objeto binding
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // Devuelve un nuevo ViewHolder con el binding
        return PokemonViewHolder(binding)
    }

    // Este método devuelve el número total de elementos en la lista de datos.
    override fun getItemCount(): Int {
        return data.size
    }
}
