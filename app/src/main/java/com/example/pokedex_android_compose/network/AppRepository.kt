package com.example.pokedex_android_compose.network

import android.util.Log
import com.example.pokedex_android_compose.network.model.PokemonSearchResult
import java.lang.Exception
import javax.inject.Inject

interface AppRepository {
    suspend fun fetchPokemon(): List<PokemonSearchResult>
}

class AppRepositoryImpl @Inject constructor(private val appService: AppService): AppRepository {
    override suspend fun fetchPokemon(): List<PokemonSearchResult> {
        return try {
            val response = appService.all()
            response.toDomain
        } catch (e: Exception) {
            Log.d("FETCH POKEMON", e.toString())
            listOf()
        }
    }
}