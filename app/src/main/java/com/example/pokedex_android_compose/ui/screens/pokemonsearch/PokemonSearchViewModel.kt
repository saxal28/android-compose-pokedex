package com.example.pokedex_android_compose.ui.screens.pokemonsearch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex_android_compose.MainApplication
import com.example.pokedex_android_compose.network.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonSearchViewModel: ViewModel() {

    @Inject
    lateinit var repository: AppRepository

    private val _viewState: PokemonSearchViewState by mutableStateOf(PokemonSearchViewState())
    val viewState get() = _viewState

    init {
        MainApplication.appComponent.inject(this)

        viewModelScope.launch {
            val results = repository.fetchPokemon()
            _viewState.pokemon = results
        }
    }
}