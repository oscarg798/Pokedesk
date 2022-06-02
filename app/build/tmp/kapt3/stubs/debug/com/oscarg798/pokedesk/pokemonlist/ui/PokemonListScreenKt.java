package com.oscarg798.pokedesk.pokemonlist.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0003\u001a@\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0010H\u0003\u001a5\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0010\u00a2\u0006\u0002\b\u0016H\u0003\u001a\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007\u001a\f\u0010\u001c\u001a\u00020\f*\u00020\u0013H\u0002\u001a\u0012\u0010\u001d\u001a\u00020\u0003*\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"FirstItem", "", "LoadingList", "", "LoadingMoreContent", "modifier", "Landroidx/compose/ui/Modifier;", "PokemonList", "pokemonListItems", "", "Lcom/oscarg798/pokedesk/pokemonlist/model/PokemonListItem;", "loading", "", "onBottomReached", "Lkotlin/Function0;", "onItemClicked", "Lkotlin/Function1;", "PokemonListLazyColumn", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "content", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "PokemonScreen", "viewModel", "Lcom/oscarg798/pokedesk/pokemonlist/ui/PokemonListViewModel;", "navController", "Landroidx/navigation/NavController;", "isScrolledToEnd", "pokemonScreen", "Landroidx/navigation/NavGraphBuilder;", "app_debug"})
public final class PokemonListScreenKt {
    private static final int FirstItem = 0;
    
    public static final void pokemonScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavGraphBuilder $this$pokemonScreen, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PokemonScreen(@org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel viewModel, @org.jetbrains.annotations.NotNull
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void LoadingList() {
    }
    
    @androidx.compose.runtime.Composable
    private static final void PokemonList(java.util.List<com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem> pokemonListItems, boolean loading, kotlin.jvm.functions.Function0<kotlin.Unit> onBottomReached, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemClicked) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void LoadingMoreContent(androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void PokemonListLazyColumn(androidx.compose.ui.Modifier modifier, androidx.compose.foundation.lazy.LazyListState listState, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> content) {
    }
    
    private static final boolean isScrolledToEnd(androidx.compose.foundation.lazy.LazyListState $this$isScrolledToEnd) {
        return false;
    }
}