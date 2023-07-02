package com.example.pokedex_android_compose.network.model

import java.util.Locale

data class PokemonSearchResult(
    val name: String,
    val id: String
) {
    val image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
    val capitalizedName = name.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(
            Locale.ENGLISH
        ) else it.toString()
    }
}