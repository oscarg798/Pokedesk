package com.oscarg798.pokedesk.lib.definitions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

abstract class AbstractViewModel<ViewState, Event>(
    private val initialState: ViewState,
    private val coroutineContextProvider: CoroutineContextProvider
) : ViewModel(), CoroutineContextProvider by coroutineContextProvider {

    private val _event = MutableSharedFlow<Event>(
        extraBufferCapacity = 1
    )

    private val _state = MutableSharedFlow<ViewState>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    private val mutex: Mutex = Mutex()

    val state: Flow<ViewState>
        get() = _state

    val events: Flow<Event>
        get() = _event

    protected suspend fun update(reducer: (ViewState) -> ViewState) {
        mutex.withLock {
            _state.emit(
                reducer(currentState())
            )
        }
    }

    protected fun updateSync(reducer: (ViewState) -> ViewState) {
        launch { update { state -> reducer(state) } }
    }

    private fun currentState() = _state.replayCache.firstOrNull() ?: initialState
}

fun <ViewState, Event> AbstractViewModel<ViewState, Event>.launch(block: suspend CoroutineScope.() -> Unit) =
    viewModelScope.launch {
        block()
    }