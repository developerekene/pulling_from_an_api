package com.example.pokemvvm.ui.pokelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemvvm.R
import com.example.pokemvvm.model.api.PokeResult
import kotlinx.android.synthetic.main.card_pokemon_search.view.*
import kotlinx.android.synthetic.main.card_pokemon_search.view.*
import org.w3c.dom.Text

class PokeListAdapter(val context: Context, val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<PokeListAdapter.SearchViewHolder>() {
    var pokemonList: List<PokeResult> = emptyList<PokeResult>()

    fun setData(list: List<PokeResult>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon_search, parent,false))
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.pokemonText.text = "#${position + 1} - ${pokemon.name}"

        Glide
            .with(context)
            .load("https://raw.githubusercontent" +
                    ".com/PokeAPI/sprites/master/sprites/pokemon/other" +
                    "/official-artwork/${position + 1}.png")
            .centerCrop()
            .into(holder.itemView.profileImage)

        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}