package com.oscarg798.pokedesk.lib

import androidx.compose.runtime.staticCompositionLocalOf

val LocalViewModelStore = staticCompositionLocalOf<ViewModelStore> {
    error("ViewModel must be provided first")
}
