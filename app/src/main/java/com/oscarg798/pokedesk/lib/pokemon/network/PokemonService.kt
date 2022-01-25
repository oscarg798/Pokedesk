package com.oscarg798.pokedesk.lib.pokemon.network

import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): ApiPokemon

    @GET("pokemon")
    suspend fun getPokemonListItems(
        @Query("limit")
        limit: Int,
        @Query("offset")
        offset: Int
    ): ApiPokemonListResponse
}
