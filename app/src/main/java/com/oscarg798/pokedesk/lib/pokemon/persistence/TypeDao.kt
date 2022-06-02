package com.oscarg798.pokedesk.lib.pokemon.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonTypeRef
import com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity

@Dao
interface TypeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(typeEntity: TypeEntity)

    @Query("select * from typeentity where id=:id")
    fun getById(id: Int): TypeEntity

    @Query("select typeId from pokemontyperef where pokemonId=:pokemonId")
    fun getTypeIdFromPokemonId(pokemonId: Int): List<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pokemonTypeRef: PokemonTypeRef)
}
