package com.oscarg798.pokedesk.lib.pokemon.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00016B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0019\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120%0$J\u0019\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\f\u0010+\u001a\u00020,*\u00020-H\u0002J\u0015\u0010.\u001a\u00020\u0012*\u00020/H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100J\f\u0010.\u001a\u00020\u0012*\u00020\u001fH\u0002J\u0015\u00101\u001a\u00020!*\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00102J\f\u00103\u001a\u000204*\u00020\'H\u0002J\f\u00103\u001a\u000204*\u000205H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/repository/PokemonRepository;", "", "pokemonService", "Lcom/oscarg798/pokedesk/lib/pokemon/network/PokemonService;", "typeService", "Lcom/oscarg798/pokedesk/lib/type/TypeService;", "idExtractor", "Lcom/oscarg798/pokedesk/lib/pokemon/utils/IdExtractor;", "pokemonDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/PokemonDao;", "typeDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/TypeDao;", "statsDao", "Lcom/oscarg798/pokedesk/lib/pokemon/persistence/StatsDao;", "gson", "Lcom/google/gson/Gson;", "(Lcom/oscarg798/pokedesk/lib/pokemon/network/PokemonService;Lcom/oscarg798/pokedesk/lib/type/TypeService;Lcom/oscarg798/pokedesk/lib/pokemon/utils/IdExtractor;Lcom/oscarg798/pokedesk/lib/pokemon/persistence/PokemonDao;Lcom/oscarg798/pokedesk/lib/pokemon/persistence/TypeDao;Lcom/oscarg798/pokedesk/lib/pokemon/persistence/StatsDao;Lcom/google/gson/Gson;)V", "fetchPokemonDetail", "Lcom/oscarg798/pokedesk/lib/pokemon/model/Pokemon;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPokemons", "", "offSet", "getPokemonDetail", "Lkotlinx/coroutines/Deferred;", "apiPokemonListItem", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemonListItem;", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemonListItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemonEntitiyWithTypesAndStats", "Lcom/oscarg798/pokedesk/lib/pokemon/repository/PokemonRepository$PokemonEntityWithTypesAndStats;", "pokemonEntity", "Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonEntity;", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPokemons", "Lkotlinx/coroutines/flow/Flow;", "", "getType", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiType;", "type", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$APIType;", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon$APIType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDamageRelationType", "Lcom/oscarg798/pokedesk/lib/pokemon/model/Pokemon$Type$DamageRelations$Type;", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiType$ApiDamageRelation$ApiDamageRelationType;", "toPokemon", "Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon;", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/ApiPokemon;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toPokemonEntitySavingStatsAndTypes", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/Pokemon;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toType", "Lcom/oscarg798/pokedesk/lib/pokemon/model/Pokemon$Type;", "Lcom/oscarg798/pokedesk/lib/pokemon/model/TypeEntity;", "PokemonEntityWithTypesAndStats", "app_debug"})
@javax.inject.Singleton
public final class PokemonRepository {
    private final com.oscarg798.pokedesk.lib.pokemon.network.PokemonService pokemonService = null;
    private final com.oscarg798.pokedesk.lib.type.TypeService typeService = null;
    private final com.oscarg798.pokedesk.lib.pokemon.utils.IdExtractor idExtractor = null;
    private final com.oscarg798.pokedesk.lib.pokemon.persistence.PokemonDao pokemonDao = null;
    private final com.oscarg798.pokedesk.lib.pokemon.persistence.TypeDao typeDao = null;
    private final com.oscarg798.pokedesk.lib.pokemon.persistence.StatsDao statsDao = null;
    private final com.google.gson.Gson gson = null;
    
    @javax.inject.Inject
    public PokemonRepository(@org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.network.PokemonService pokemonService, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.type.TypeService typeService, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.utils.IdExtractor idExtractor, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.persistence.PokemonDao pokemonDao, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.persistence.TypeDao typeDao, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.pokemon.persistence.StatsDao statsDao, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.oscarg798.pokedesk.lib.pokemon.model.Pokemon>> getPokemons() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchPokemons(int offSet, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getPokemonDetail(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.oscarg798.pokedesk.lib.pokemon.model.Pokemon> continuation) {
        return null;
    }
    
    private final com.oscarg798.pokedesk.lib.pokemon.model.Pokemon toPokemon(com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository.PokemonEntityWithTypesAndStats $this$toPokemon) {
        return null;
    }
    
    private final java.lang.Object getPokemonEntitiyWithTypesAndStats(com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity pokemonEntity, kotlin.coroutines.Continuation<? super com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository.PokemonEntityWithTypesAndStats> continuation) {
        return null;
    }
    
    private final java.lang.Object getPokemonDetail(com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListItem apiPokemonListItem, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Deferred<com.oscarg798.pokedesk.lib.pokemon.model.Pokemon>> continuation) {
        return null;
    }
    
    private final java.lang.Object fetchPokemonDetail(int id, kotlin.coroutines.Continuation<? super com.oscarg798.pokedesk.lib.pokemon.model.Pokemon> continuation) {
        return null;
    }
    
    private final java.lang.Object toPokemon(com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon $this$toPokemon, kotlin.coroutines.Continuation<? super com.oscarg798.pokedesk.lib.pokemon.model.Pokemon> p1) {
        return null;
    }
    
    private final java.lang.Object getType(com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon.APIType type, kotlin.coroutines.Continuation<? super com.oscarg798.pokedesk.lib.pokemon.model.ApiType> continuation) {
        return null;
    }
    
    private final com.oscarg798.pokedesk.lib.pokemon.model.Pokemon.Type toType(com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity $this$toType) {
        return null;
    }
    
    private final com.oscarg798.pokedesk.lib.pokemon.model.Pokemon.Type toType(com.oscarg798.pokedesk.lib.pokemon.model.ApiType $this$toType) {
        return null;
    }
    
    private final java.lang.Object toPokemonEntitySavingStatsAndTypes(com.oscarg798.pokedesk.lib.pokemon.model.Pokemon $this$toPokemonEntitySavingStatsAndTypes, kotlin.coroutines.Continuation<? super com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity> p1) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/oscarg798/pokedesk/lib/pokemon/repository/PokemonRepository$PokemonEntityWithTypesAndStats;", "", "pokemonEntity", "Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonEntity;", "types", "", "Lcom/oscarg798/pokedesk/lib/pokemon/model/TypeEntity;", "stats", "Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonEntity$Stat;", "(Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonEntity;Ljava/util/Set;Ljava/util/Set;)V", "getPokemonEntity", "()Lcom/oscarg798/pokedesk/lib/pokemon/model/PokemonEntity;", "getStats", "()Ljava/util/Set;", "getTypes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    static final class PokemonEntityWithTypesAndStats {
        @org.jetbrains.annotations.NotNull
        private final com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity pokemonEntity = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity> types = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat> stats = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository.PokemonEntityWithTypesAndStats copy(@org.jetbrains.annotations.NotNull
        com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity pokemonEntity, @org.jetbrains.annotations.NotNull
        java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity> types, @org.jetbrains.annotations.NotNull
        java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat> stats) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public PokemonEntityWithTypesAndStats(@org.jetbrains.annotations.NotNull
        com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity pokemonEntity, @org.jetbrains.annotations.NotNull
        java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity> types, @org.jetbrains.annotations.NotNull
        java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat> stats) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity getPokemonEntity() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity> getTypes() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Set<com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity.Stat> getStats() {
            return null;
        }
    }
}