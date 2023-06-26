package com.example.pokedex_android_compose.network.dto


import com.google.gson.annotations.SerializedName

data class PokemonListResponseDto(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<Result?>?
) {
    data class Result(
        @SerializedName("name")
        val name: String?,
        @SerializedName("url")
        val url: String?
    )
}