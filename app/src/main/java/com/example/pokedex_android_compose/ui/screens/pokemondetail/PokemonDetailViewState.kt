package com.example.pokedex_android_compose.ui.screens.pokemondetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.pokedex_android_compose.network.model.PokemonDetail

class PokemonDetailViewState {
    var pokemonDetail: PokemonDetail? by mutableStateOf(null)
    var isLoading by mutableStateOf(false)
        private set

    fun isLoading() {
        isLoading = true
    }

    fun finishedLoading() {
        isLoading = false
    }
}