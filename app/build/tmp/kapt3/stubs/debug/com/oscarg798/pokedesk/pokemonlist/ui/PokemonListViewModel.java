package com.oscarg798.pokedesk.pokemonlist.ui;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0015\u0016B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel;", "Lcom/oscarg798/pokedesk/lib/definitions/AbstractViewModel;", "Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel$State;", "Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel$Event;", "getPokemonListItems", "Lcom/oscarg798/pokedesk/pokemonlist/usecase/GetPokemonListItems;", "fetchPokemons", "Lcom/oscarg798/pokedesk/pokemonlist/usecase/FetchPokemons;", "coroutineContextProvider", "Lcom/oscarg798/pokedesk/lib/definitions/CoroutineContextProvider;", "(Lcom/oscarg798/pokedesk/pokemonlist/usecase/GetPokemonListItems;Lcom/oscarg798/pokedesk/pokemonlist/usecase/FetchPokemons;Lcom/oscarg798/pokedesk/lib/definitions/CoroutineContextProvider;)V", "fetchPokemonListItems", "", "getPokemons", "onItemClicked", "id", "", "onQueryUpdated", "query", "", "onSearch", "Event", "State", "app_debug"})
public final class PokemonListViewModel extends com.oscarg798.pokedesk.lib.definitions.AbstractViewModel<com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel.State, com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel.Event> {
    private final com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems getPokemonListItems = null;
    private final com.oscarg798.pokedesk.pokemonlist.usecase.FetchPokemons fetchPokemons = null;
    
    @javax.inject.Inject
    public PokemonListViewModel(@org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems getPokemonListItems, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.pokemonlist.usecase.FetchPokemons fetchPokemons, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider coroutineContextProvider) {
        super(null, null);
    }
    
    public final void fetchPokemonListItems() {
    }
    
    private final void getPokemons() {
    }
    
    public final void onItemClicked(int id) {
    }
    
    public final void onQueryUpdated(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void onSearch() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel$State;", "", "loading", "", "currentSearchQuery", "", "pokemonListItems", "", "Lcom/oscarg798/pokedesk/pokemonlist/model/PokemonListItem;", "(ZLjava/lang/String;Ljava/util/List;)V", "getCurrentSearchQuery", "()Ljava/lang/String;", "getLoading", "()Z", "getPokemonListItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class State {
        private final boolean loading = false;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String currentSearchQuery = null;
        @org.jetbrains.annotations.Nullable
        private final java.util.List<com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem> pokemonListItems = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel.State copy(boolean loading, @org.jetbrains.annotations.NotNull
        java.lang.String currentSearchQuery, @org.jetbrains.annotations.Nullable
        java.util.List<com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem> pokemonListItems) {
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
        
        public State(boolean loading, @org.jetbrains.annotations.NotNull
        java.lang.String currentSearchQuery, @org.jetbrains.annotations.Nullable
        java.util.List<com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem> pokemonListItems) {
            super();
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean getLoading() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCurrentSearchQuery() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.util.List<com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem> getPokemonListItems() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel$Event;", "", "NavigateToDetail", "Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel$Event$NavigateToDetail;", "app_debug"})
    public static abstract interface Event {
        
        @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel$Event$NavigateToDetail;", "Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel$Event;", "id", "", "(I)V", "getId", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
        public static final class NavigateToDetail implements com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel.Event {
            private final int id = 0;
            
            @org.jetbrains.annotations.NotNull
            public final com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel.Event.NavigateToDetail copy(int id) {
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
            
            public NavigateToDetail(int id) {
                super();
            }
            
            public final int component1() {
                return 0;
            }
            
            public final int getId() {
                return 0;
            }
        }
    }
}