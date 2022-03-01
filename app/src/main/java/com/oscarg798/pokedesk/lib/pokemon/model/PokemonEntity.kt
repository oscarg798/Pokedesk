package com.oscarg798.pokedesk.lib.pokemon.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "order")
    val order: Int,
    @ColumnInfo(name = "height")
    val height: Int,
    @ColumnInfo(name = "weight")
    val weight: Int,
    @ColumnInfo(name = "image")
    val image: String
) {

    @Entity
    data class Stat(
        @PrimaryKey(autoGenerate = true)
        val id: Int? = null,
        @ColumnInfo(name = "statId")
        val statId: Int,
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "value")
        val value: Int,
        @ColumnInfo(name = "pokemonId")
        val pokemonId: Int
    )
}

@Entity(primaryKeys = ["pokemonId", "typeId"])
data class PokemonTypeRef(
    @ColumnInfo(name = "pokemonId")
    val pokemonId: Int,
    @ColumnInfo(name = "typeId")
    val typeId: Int
)
