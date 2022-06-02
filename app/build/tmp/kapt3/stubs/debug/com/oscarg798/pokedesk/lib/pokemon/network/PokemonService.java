package com.oscarg798.pokedesk.lib.pokemon.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/network/PokemonService;", "", "getPokemonDetail", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemonListItems", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemonListResponse;", "limit", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PokemonService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "pokemon/{id}")
    public abstract java.lang.Object getPokemonDetail(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "pokemon")
    public abstract java.lang.Object getPokemonListItems(@retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "offset")
    int offset, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListResponse> continuation);
}