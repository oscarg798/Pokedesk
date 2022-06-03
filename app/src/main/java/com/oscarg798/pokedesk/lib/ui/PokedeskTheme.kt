package com.oscarg798.pokedesk.lib.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

@Composable
private fun ProvideThemeConfig(
    dimensions: Dimensions,
    content: @Composable () -> Unit
) {
    val rememberedDimensions = remember { dimensions }
    CompositionLocalProvider(
        LocalAppDimens provides rememberedDimensions
    ) {
        content()
    }
}

@Composable
fun PokeDeskTheme(content: @Composable () -> Unit,) {
    val fontSizes = if (isSmallScreen()) normalFontSizes else smallFontSizes
    ProvideThemeConfig(
        if (isSmallScreen()) normalDimensions else smallDimensions,
    ) {
        MaterialTheme(
            colors = if (isSystemInDarkTheme()) darkColors else lightColors,
            typography = getTypography(fontSizes)
        ) { content() }
    }
}

val MaterialTheme.Dimensions: Dimensions
    @Composable
    get() = LocalAppDimens.current

@Composable
private fun isSmallScreen() = LocalConfiguration.current.screenWidthDp > 360
