package com.oscarg798.pokedesk.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/oscarg798/pokedesk/di/AppModule;", "", "()V", "provideCoroutineContextProvider", "Lcom/oscarg798/pokedesk/lib/definitions/CoroutineContextProvider;", "provideDatabase", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/PokeDexDatabase;", "context", "Landroid/content/Context;", "providePokemonDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/PokemonDao;", "pokeDexDatabase", "providePokemonStatDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/StatsDao;", "providePokemonTypeDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/TypeDao;", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.oscarg798.pokedesk.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider provideCoroutineContextProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.oscarg798.pokedesk.lib.pokemon.persistence.PokeDexDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @dagger.Reusable()
    public final com.oscarg798.pokedesk.lib.pokemon.persistence.PokemonDao providePokemonDao(@org.jetbrains.annotations.NotNull()
    com.oscarg798.pokedesk.lib.pokemon.persistence.PokeDexDatabase pokeDexDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @dagger.Reusable()
    public final com.oscarg798.pokedesk.lib.pokemon.persistence.TypeDao providePokemonTypeDao(@org.jetbrains.annotations.NotNull()
    com.oscarg798.pokedesk.lib.pokemon.persistence.PokeDexDatabase pokeDexDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @dagger.Reusable()
    public final com.oscarg798.pokedesk.lib.pokemon.persistence.StatsDao providePokemonStatDao(@org.jetbrains.annotations.NotNull()
    com.oscarg798.pokedesk.lib.pokemon.persistence.PokeDexDatabase pokeDexDatabase) {
        return null;
    }
}