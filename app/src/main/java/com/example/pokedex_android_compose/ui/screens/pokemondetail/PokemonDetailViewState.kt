package com.example.pokedex_android_compose.ui.screens.pokemondetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.pokedex_android_compose.network.model.PokemonDetail

class PokemonDetailViewState {
    var selectedTabIndex: Int by mutableStateOf(0)
    var pokemonDetail: PokemonDetail? by mutableStateOf(null)

    val tabs: List<String> = listOf("About", "Base Stats", "Evolution", "Moves")

    fun selectTab(index: Int) {
        selectedTabIndex = index
    }
}