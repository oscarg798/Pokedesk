package com.oscarg798.pokedesk.lib.definitions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0007J\r\u0010\u001e\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u001fJ%\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000#H\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u001c\u0010%\u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000#H\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\tX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0005\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u0012\u0010\u0018\u001a\u00020\u000eX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/oscarg798/pokedesk/lib/definitions/AbstractViewModel;", "ViewState", "Event", "Landroidx/lifecycle/ViewModel;", "Lcom/oscarg798/pokedesk/lib/definitions/CoroutineContextProvider;", "initialState", "coroutineContextProvider", "(Ljava/lang/Object;Lcom/oscarg798/pokedesk/lib/definitions/CoroutineContextProvider;)V", "_event", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "get_event", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "_state", "computation", "Lkotlin/coroutines/CoroutineContext;", "getComputation", "()Lkotlin/coroutines/CoroutineContext;", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Object;", "io", "getIo", "main", "getMain", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "state", "getState", "currentState", "()Ljava/lang/Object;", "update", "", "reducer", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSync", "app_debug"})
public abstract class AbstractViewModel<ViewState extends java.lang.Object, Event extends java.lang.Object> extends androidx.lifecycle.ViewModel implements com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider {
    private final ViewState initialState = null;
    private final com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider coroutineContextProvider = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<Event> _event = null;
    private final kotlinx.coroutines.flow.MutableSharedFlow<ViewState> _state = null;
    private final kotlinx.coroutines.sync.Mutex mutex = null;
    
    public AbstractViewModel(ViewState initialState, @org.jetbrains.annotations.NotNull
    com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider coroutineContextProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    protected final kotlinx.coroutines.flow.MutableSharedFlow<Event> get_event() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<ViewState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<Event> getEvents() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    protected final java.lang.Object update(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super ViewState, ? extends ViewState> reducer, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    protected final void updateSync(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super ViewState, ? extends ViewState> reducer) {
    }
    
    protected final ViewState currentState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getComputation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getIo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlin.coroutines.CoroutineContext getMain() {
        return null;
    }
}