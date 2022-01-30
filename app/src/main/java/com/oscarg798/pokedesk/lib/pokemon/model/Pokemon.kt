package com.oscarg798.pokedesk.lib.pokemon.model

data class Pokemon(
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
        val damageRelations: DamageRelations
    ) {
        data class DamageRelations(
            val vulnerableTo: Set<Type>,
            val resistantAgainst: Set<Type>,
            val weakTo: Set<Type>,
            val strongAgainst: Set<Type>,
            val noEffectiveTo: Set<Type>,
            val noAffectedAgainst: Set<Type>
        ) {
            data class Type(
                val id: Int,
                val name: String
            )
        }
    }

    data class Stat(
        val id: Int,
        val name: String,
        val value: Int
    )
}
