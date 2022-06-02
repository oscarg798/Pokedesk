package com.oscarg798.pokedesk.lib.pokemon.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemonEntity: PokemonEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemonEntities: List<PokemonEntity>)

    @Query("SELECT * FROM pokemonentity")
    fun getAll(): Flow<List<PokemonEntity>>

    @Query("select * from pokemonentity where id=:id")
    fun getById(id: Int): PokemonEntity
}
