package com.oscarg798.pokedesk.lib.pokemon.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemonListResponse;", "", "count", "", "items", "", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemonListItem;", "(ILjava/util/List;)V", "getCount", "()I", "getItems", "()Ljava/util/List;", "app_debug"})
public final class ApiPokemonListResponse {
    @com.google.gson.annotations.SerializedName(value = "count")
    private final int count = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "results")
    private final java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListItem> items = null;
    
    public ApiPokemonListResponse(int count, @org.jetbrains.annotations.NotNull
    java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListItem> items) {
        super();
    }
    
    public final int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListItem> getItems() {
        return null;
    }
}