package com.oscarg798.pokedesk.lib.pokemon.persistence;

import java.lang.System;

@androidx.room.Database(entities = {com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.class, com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity.class, com.oscarg798.pokedesk.lib.pokemon.model.PokemonTypeRef.class, com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat.class}, version = 1)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/persistence/PokeDexDatabase;", "Landroidx/room/RoomDatabase;", "()V", "pokemonDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/PokemonDao;", "statDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/StatsDao;", "typeDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/TypeDao;", "app_debug"})
public abstract class PokeDexDatabase extends androidx.room.RoomDatabase {
    
    public PokeDexDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.oscarg798.pokedesk.lib.pokemon.persistence.PokemonDao pokemonDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.oscarg798.pokedesk.lib.pokemon.persistence.TypeDao typeDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.oscarg798.pokedesk.lib.pokemon.persistence.StatsDao statDao();
}