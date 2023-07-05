package com.example.pokedex_android_compose.ui.screens.pokemonsearch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.pokedex_android_compose.network.model.PokemonSearchResult

class PokemonSearchViewState {
    var pokemon: List<PokemonSearchResult> by mutableStateOf(listOf())
    var searchText by mutableStateOf("sq")

    val autocomplete get() = if (searchText.length >= 2) {
        pokemon.filter { it.name.contains(searchText) }.take(4)
    } else {
        listOf()
    }

    fun onChange(value: String) {
        searchText = value
    }

    fun clear() {
        searchText = ""
    }
}
