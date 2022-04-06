package com.example.pokemvvm.ui.pokelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pokemvvm.R
import com.example.pokemvvm.ui.pokeinfo.PokeInfoActivity
import kotlinx.android.synthetic.main.activity_pokeinfo.*
import kotlinx.android.synthetic.main.activity_pokelist.*

class PokeListActivity : AppCompatActivity() {
    
    private lateinit var viewModel: PokeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokelist)
        supportActionBar?.hide()

        viewModel = ViewModelProvider(this).get(PokeListViewModel::class.java)

        initUI()
    }

    private fun initUI(){
        pokelistRecyclerView.layoutManager = LinearLayoutManager(this)

        pokelistRecyclerView.adapter = PokeListAdapter(this) {
            val intent = Intent(this, PokeInfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }

        viewModel.getPokemonList()

        viewModel.pokemonList.observe(this, Observer { list ->
            (pokelistRecyclerView.adapter as PokeListAdapter).setData(list)
        })
    }
}