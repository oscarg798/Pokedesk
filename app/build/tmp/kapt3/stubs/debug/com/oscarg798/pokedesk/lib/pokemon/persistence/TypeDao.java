package com.oscarg798.pokedesk.lib.pokemon.persistence;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\u0005H\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/persistence/TypeDao;", "", "getById", "Lcom/oscarg798/pokedesk/lib/pokemon/model/TypeEntity;", "id", "", "getTypeIdFromPokemonId", "", "pokemonId", "insert", "", "pokemonTypeRef", "Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonTypeRef;", "typeEntity", "app_debug"})
public abstract interface TypeDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity typeEntity);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "select * from typeentity where id=:id")
    public abstract com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity getById(int id);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "select typeId from pokemontyperef where pokemonId=:pokemonId")
    public abstract java.util.List<java.lang.Integer> getTypeIdFromPokemonId(int pokemonId);
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.IGNORE)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.model.PokemonTypeRef pokemonTypeRef);
}