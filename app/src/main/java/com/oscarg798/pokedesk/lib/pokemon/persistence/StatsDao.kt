package com.oscarg798.pokedesk.lib.pokemon.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity

@Dao
interface StatsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(stat: PokemonEntity.Stat)

    @Query("select * from stat where pokemonId=:pokemonId")
    fun getByPokemonId(pokemonId: Int): List<PokemonEntity.Stat>
}
