package com.example.pokedex_android_compose.network.model

import com.example.pokedex_android_compose.ui.common.PokemonColorPicker
import java.util.Locale

data class PokemonDetail(
    val name: String,
    val types: List<String>,
    val id: String,
    val image: String
) {
    private val mainType = types.firstOrNull()
    val colors = PokemonColorPicker().invoke(mainType)
    val capitalizedName = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    val idDisplay = when (id.length) {
        1 -> "#00$id"
        2 -> "#0$id"
        else -> "#$id"
    }
}