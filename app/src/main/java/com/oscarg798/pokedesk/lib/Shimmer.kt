package com.oscarg798.pokedesk.lib

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.oscarg798.pokedesk.lib.ui.Dimensions

@Composable
fun Modifier.shimmer(): Modifier {
    return this.placeholder(
        visible = true,
        shape = RoundedCornerShape(MaterialTheme.Dimensions.Medium),
        color = MaterialTheme.colors.surface,
        highlight = PlaceholderHighlight.shimmer(
            highlightColor = ShimmerColor
        )
    )
}

private val ShimmerColor = Color(
    0xffcccccc
)
