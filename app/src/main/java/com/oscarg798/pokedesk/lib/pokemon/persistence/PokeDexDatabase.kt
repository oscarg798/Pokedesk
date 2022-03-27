package com.oscarg798.pokedesk.lib.pokemon.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonTypeRef
import com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity

@Database(entities = [PokemonEntity::class, TypeEntity::class, PokemonTypeRef::class, PokemonEntity.Stat::class], version = 1)
abstract class PokeDexDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    abstract fun typeDao(): TypeDao

    abstract fun statDao(): StatsDao
}
