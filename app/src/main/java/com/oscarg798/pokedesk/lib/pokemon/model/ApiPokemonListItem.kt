package com.oscarg798.pokedesk.lib.pokemon.model

import com.google.gson.annotations.SerializedName

class ApiPokemonListItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
