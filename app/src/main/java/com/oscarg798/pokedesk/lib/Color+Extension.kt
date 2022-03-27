package com.oscarg798.pokedesk.lib

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

fun Color.isDarkColor(): Boolean {
    return luminance() < DarkColorLuminanceThreshold
}

private const val DarkColorLuminanceThreshold = .5
