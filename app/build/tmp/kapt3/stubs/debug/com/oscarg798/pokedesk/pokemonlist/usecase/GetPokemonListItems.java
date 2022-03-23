package com.oscarg798.pokedesk.pokemonlist.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/oscarg798/pokedesk/pokemonlist/usecase/GetPokemonListItems;", "", "pokemonRepository", "Lcom/oscarg798/pokedesk/lib/pokemon/repository/PokemonRepository;", "typeRepository", "Lcom/oscarg798/pokedesk/lib/type/TypeRepository;", "(Lcom/oscarg798/pokedesk/lib/pokemon/repository/PokemonRepository;Lcom/oscarg798/pokedesk/lib/type/TypeRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/oscarg798/pokedesk/pokemonlist/model/PokemonListItem;", "app_debug"})
@dagger.Reusable()
public final class GetPokemonListItems {
    private final com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository pokemonRepository = null;
    private final com.oscarg798.pokedesk.lib.type.TypeRepository typeRepository = null;
    
    @javax.inject.Inject()
    public GetPokemonListItems(@org.jetbrains.annotations.NotNull()
    com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository pokemonRepository, @org.jetbrains.annotations.NotNull()
    com.oscarg798.pokedesk.lib.type.TypeRepository typeRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem>> invoke() {
        return null;
    }
}