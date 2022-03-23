package com.oscarg798.pokedesk.detail.ui;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ActivityComponent.class})
@dagger.hilt.EntryPoint()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailEntryPoint;", "", "pokemonDetailFactory", "Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailViewModel$Factory;", "app_debug"})
public abstract interface PokemonDetailEntryPoint {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.oscarg798.pokedesk.detail.ui.PokemonDetailViewModel.Factory pokemonDetailFactory();
}