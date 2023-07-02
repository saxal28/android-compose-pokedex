package com.example.pokedex_android_compose.network

import com.example.pokedex_android_compose.network.dto.PokemonListResponseDto
import com.example.pokedex_android_compose.network.model.PokemonSearchResult

val PokemonListResponseDto?.toDomain: List<PokemonSearchResult>
    get() {
        return this?.results?.map {
            val name = it?.name ?: ""
            val id = (Regex("/\\d+/").find(it?.url ?: "")?.value ?: "").replace("/", "")
            PokemonSearchResult(name, id)
        } ?: listOf()
    }