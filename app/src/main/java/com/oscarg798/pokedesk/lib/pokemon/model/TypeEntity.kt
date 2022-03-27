package com.oscarg798.pokedesk.lib.pokemon.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TypeEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "vulnerableTo")
    val vulnerableTo: String,
    @ColumnInfo(name = "resistantAgainst")
    val resistantAgainst: String,
    @ColumnInfo(name = "weakTo")
    val weakTo: String,
    @ColumnInfo(name = "strongAgainst")
    val strongAgainst: String,
    @ColumnInfo(name = "noEffectiveTo")
    val noEffectiveTo: String,
    @ColumnInfo(name = "noAffectedAgainst")
    val noAffectedAgainst: String
)
