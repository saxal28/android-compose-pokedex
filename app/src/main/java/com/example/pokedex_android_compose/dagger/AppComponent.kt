package com.example.pokedex_android_compose.dagger

import com.example.pokedex_android_compose.MainActivity
import com.example.pokedex_android_compose.ui.screens.pokemonsearch.PokemonSearchViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(pokemonSearchViewModel: PokemonSearchViewModel)
}