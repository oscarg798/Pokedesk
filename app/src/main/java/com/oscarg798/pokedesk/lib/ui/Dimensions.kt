package com.oscarg798.pokedesk.lib.ui

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

interface Dimensions {
    val ExtraSmall: Dp
    val Small: Dp
    val Medium: Dp
    val Large: Dp
}

val smallDimensions = object : Dimensions {
    override val ExtraSmall: Dp
        get() = 1.5f.dp
    override val Small: Dp
        get() = 3.dp
    override val Medium: Dp
        get() = 6.dp
    override val Large: Dp
        get() = 9.dp
}

val normalDimensions = object : Dimensions {
    override val ExtraSmall: Dp
        get() = 4.dp
    override val Small: Dp
        get() = 8.dp
    override val Medium: Dp
        get() = 16.dp
    override val Large: Dp
        get() = 24.dp
}

internal val LocalAppDimens = staticCompositionLocalOf<Dimensions> {
    error("You must provide a Dimension set before")
}