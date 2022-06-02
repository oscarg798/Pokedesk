package com.oscarg798.pokedesk.detail.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\r\u000e\u000fB!\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailViewModel;", "Lcom/oscarg798/pokedesk/lib/definitions/AbstractViewModel;", "Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailViewModel$State;", "Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailViewModel$Event;", "id", "", "getPokemonDetail", "Lcom/oscarg798/pokedesk/detail/usecase/GetPokemonDetail;", "coroutineContextProvider", "Lcom/oscarg798/pokedesk/lib/definitions/CoroutineContextProvider;", "(ILcom/oscarg798/pokedesk/detail/usecase/GetPokemonDetail;Lcom/oscarg798/pokedesk/lib/definitions/CoroutineContextProvider;)V", "getDetail", "", "Event", "Factory", "State", "app_debug"})
public final class PokemonDetailViewModel extends com.oscarg798.pokedesk.lib.definitions.AbstractViewModel<com.oscarg798.pokedesk.detail.ui.PokemonDetailViewModel.State, com.oscarg798.pokedesk.detail.ui.PokemonDetailViewModel.Event> {
    private final int id = 0;
    private final com.oscarg798.pokedesk.detail.usecase.GetPokemonDetail getPokemonDetail = null;
    
    @dagger.assisted.AssistedInject
    public PokemonDetailViewModel(@dagger.assisted.Assisted
    int id, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.detail.usecase.GetPokemonDetail getPokemonDetail, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider coroutineContextProvider) {
        super(null, null);
    }
    
    private final void getDetail() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailViewModel$State;", "", "loading", "", "pokemon", "Lcom/oscarg798/pokedesk/detail/model/PokemonDetail;", "(ZLcom/oscarg798/pokedesk/detail/model/PokemonDetail;)V", "getLoading", "()Z", "getPokemon", "()Lcom/oscarg798/pokedesk/detail/model/PokemonDetail;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class State {
        private final boolean loading = false;
        @org.jetbrains.annotations.Nullable
        private final com.oscarg798.pokedesk.detail.model.PokemonDetail pokemon = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.detail.ui.PokemonDetailViewModel.State copy(boolean loading, @org.jetbrains.annotations.Nullable
        com.oscarg798.pokedesk.detail.model.PokemonDetail pokemon) {
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
        
        public State() {
            super();
        }
        
        public State(boolean loading, @org.jetbrains.annotations.Nullable
        com.oscarg798.pokedesk.detail.model.PokemonDetail pokemon) {
            super();
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean getLoading() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.oscarg798.pokedesk.detail.model.PokemonDetail component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.oscarg798.pokedesk.detail.model.PokemonDetail getPokemon() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bv\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailViewModel$Event;", "", "app_debug"})
    public static abstract interface Event {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailViewModel$Factory;", "", "create", "Lcom/oscarg798/pokedesk/detail/ui/PokemonDetailViewModel;", "id", "", "app_debug"})
    @dagger.assisted.AssistedFactory
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.oscarg798.pokedesk.detail.ui.PokemonDetailViewModel create(int id);
    }
}