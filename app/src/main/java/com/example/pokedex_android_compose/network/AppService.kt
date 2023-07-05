package com.example.pokedex_android_compose.network

import com.example.pokedex_android_compose.network.dto.PokemonDetailResponseDto
import com.example.pokedex_android_compose.network.dto.PokemonListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {
    @GET("pokemon")
    suspend fun all(@Query("limit") limit: Int = 100000): PokemonListResponseDto

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: String): PokemonDetailResponseDto
}