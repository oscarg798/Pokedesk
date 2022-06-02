package com.oscarg798.pokedesk.lib.pokemon.persistence;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\'\u00a8\u0006\n"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/persistence/StatsDao;", "", "getByPokemonId", "", "Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonEntity$Stat;", "pokemonId", "", "insert", "", "stat", "app_debug"})
public abstract interface StatsDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat stat);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "select * from stat where pokemonId=:pokemonId")
    public abstract java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat> getByPokemonId(int pokemonId);
}