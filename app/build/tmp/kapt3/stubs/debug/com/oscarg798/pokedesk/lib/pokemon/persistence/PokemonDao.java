package com.oscarg798.pokedesk.lib.pokemon.persistence;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\'J\u0016\u0010\t\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\'\u00a8\u0006\r"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/persistence/PokemonDao;", "", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonEntity;", "getById", "id", "", "insert", "", "pokemonEntity", "pokemonEntities", "app_debug"})
public abstract interface PokemonDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity pokemonEntity);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity> pokemonEntities);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM pokemonentity")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity>> getAll();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "select * from pokemonentity where id=:id")
    public abstract com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity getById(int id);
}