package com.oscarg798.pokedesk.pokemonlist.model

import androidx.compose.ui.graphics.Color

data class PokemonListItem(
    val id: Int,
    val name: String,
    val order: Int,
    val image: String,
    val types: Set<Type>
) {

    data class Type(
        val id: Int,
        val name: String,
        val color: Color
    )
}
