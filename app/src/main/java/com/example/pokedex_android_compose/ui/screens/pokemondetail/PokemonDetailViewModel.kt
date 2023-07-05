package com.example.pokedex_android_compose.ui.screens.pokemondetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android_compose.MainApplication
import com.example.pokedex_android_compose.network.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonDetailViewModel(savedStateHandle: SavedStateHandle): ViewModel() {

    @Inject
    lateinit var repository: AppRepository

    private val _viewState by mutableStateOf(PokemonDetailViewState())
    val viewState get() = _viewState

    private val id = savedStateHandle.get<String>("id") ?: ""

    init {
        MainApplication.appComponent.inject(this)

        viewModelScope.launch {
            val pokemon = repository.fetchPokemonDetail(id)
            viewState.pokemonDetail = pokemon
        }
    }
}