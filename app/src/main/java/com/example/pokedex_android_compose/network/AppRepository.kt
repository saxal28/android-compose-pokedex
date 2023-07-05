package com.example.pokedex_android_compose.network

import android.util.Log
import com.example.pokedex_android_compose.network.model.PokemonDetail
import com.example.pokedex_android_compose.network.model.PokemonSearchResult
import java.lang.Exception
import javax.inject.Inject

interface AppRepository {
    suspend fun fetchPokemon(): List<PokemonSearchResult>
    suspend fun fetchPokemonDetail(id: String): PokemonDetail?
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

    override suspend fun fetchPokemonDetail(id: String): PokemonDetail? {
        return try {
            val response = appService.getPokemonDetails(id)
            response.toDomain
        } catch (e: Exception) {
            Log.d("FETCH POKEMON DETAIL", e.toString())
            null
        }
    }
}