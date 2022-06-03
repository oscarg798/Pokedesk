package com.oscarg798.pokedesk.pokemoncardimages.network

import com.google.gson.annotations.SerializedName
import com.oscarg798.pokedesk.pokemoncardimages.model.ApiPokemonCardImages
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonTcgService {

    @GET("cards")
    suspend fun getCardImagesFromPokemonName(
        @Query("q")
        nameQuery: String
    ): PokemonCardImagesResponse

    data class PokemonCardImagesResponse(
        @SerializedName("data")
        val data: List<ApiPokemonCardImages>
    )
}
