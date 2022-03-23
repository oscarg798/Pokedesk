package com.oscarg798.pokedesk.lib.pokemon.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/di/PokemonModule;", "", "()V", "providePokemonService", "Lcom/oscarg798/pokedesk/lib/pokemon/network/PokemonService;", "retrofit", "Lretrofit2/Retrofit;", "app_debug"})
@dagger.Module()
public final class PokemonModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.oscarg798.pokedesk.lib.pokemon.di.PokemonModule INSTANCE = null;
    
    private PokemonModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @dagger.Reusable()
    public final com.oscarg798.pokedesk.lib.pokemon.network.PokemonService providePokemonService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}