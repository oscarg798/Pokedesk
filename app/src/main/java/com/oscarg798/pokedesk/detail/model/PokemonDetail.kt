package com.oscarg798.pokedesk.detail.model

import androidx.compose.ui.graphics.Color
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon

data class PokemonDetail(
    val id: Int,
    val name: String,
    val order: Int,
    val height: Int,
    val weight: Int,
    val types: Set<Type>,
    val stats: Set<Stat>,
    val image: String
) {

    data class Type(
        val id: Int,
        val name: String,
        val color: Color,
        val damageRelations: Pokemon.Type.DamageRelations
    ) {

        constructor(type: Pokemon.Type, color: Color) : this(
            id = type.id,
            name = type.name,
            color = color,
            damageRelations = type.damageRelations
        )
    }

    data class Stat(
        val id: Int,
        val name: String,
        val value: Int
    ) {

        constructor(stat: Pokemon.Stat) : this(id = stat.id, name = stat.name, value = stat.value)
    }
}
