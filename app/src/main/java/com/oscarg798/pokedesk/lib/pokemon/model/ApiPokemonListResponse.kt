package com.oscarg798.pokedesk.lib.pokemon.model

import com.google.gson.annotations.SerializedName

class ApiPokemonListResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val items: List<ApiPokemonListItem>
)
