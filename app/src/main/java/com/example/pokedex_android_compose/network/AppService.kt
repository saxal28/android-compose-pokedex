package com.example.pokedex_android_compose.network

import com.example.pokedex_android_compose.network.dto.PokemonListResponseDto
import retrofit2.http.GET

interface AppService {
    @GET("pokemon")
    suspend fun all(): PokemonListResponseDto
}