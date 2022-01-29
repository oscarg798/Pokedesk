package com.oscarg798.pokedesk.lib.definitions

import kotlin.coroutines.CoroutineContext

interface CoroutineContextProvider {
    val io: CoroutineContext
    val computation: CoroutineContext
    val main: CoroutineContext
}
