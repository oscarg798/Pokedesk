package com.oscarg798.pokedesk.detail

import android.text.TextPaint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.oscarg798.pokedesk.lib.ui.Dimensions
import com.oscarg798.pokedesk.lib.ui.PokeDeskTheme
import java.util.Locale

@Composable
internal fun PokemonStats(stats: Set<PokemonDetail.Stat>, modifier: Modifier) {

    val statsGroup = remember {
        stats.chunked(MaximumStatsPerGroup).take(StatsGroups)
    }

    Row(modifier) {
        statsGroup.forEach { statGroup ->
            StatsChart(
                stats = statGroup.toSet(),
                modifier = Modifier
                    .padding(top = MaterialTheme.Dimensions.Medium),
                statBarHeight = 150.dp
            )
        }
    }
}

@Composable
private fun StatsChart(
    stats: Set<PokemonDetail.Stat>,
    modifier: Modifier,
    statBarHeight: Dp
) {
    val textSize = MaterialTheme.typography.body1.fontSize.value * LocalDensity.current.density

    val higherStat = remember { stats.getHigherStat() }

    val colors = listOf(
        MaterialTheme.colors.primary,
        MaterialTheme.colors.primaryVariant,
        MaterialTheme.colors.secondary.copy(alpha = .8f)
    )

    val statBarWidthInCurrentDensity = StatBarContainerWidth.dp.value * LocalDensity.current.density

    val fullWidth = (stats.size.toFloat() * StatBarContainerWidth).dp

    val statBarWidth: Float = StatBarDefaultWidth.dp.value * LocalDensity.current.density

    Column(
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier
                .align(Alignment.Start)
                .width(fullWidth)
                .height(statBarHeight)
        ) {

            val containerStartCoordinates = Offset(StatHalfPadding, StatHalfPadding)
            val statContainerHeight = size.height - StatBarPadding

            val statBarContainerHeightPercentage = statContainerHeight * .2f
            val statBarContainerHeight = statContainerHeight - statBarContainerHeightPercentage

            val statContainerSize = Size(statBarWidthInCurrentDensity, size.height - StatBarPadding)

            var currentStatBarXCoordinate = 0f

            stats.forEachIndexed { index, stat ->
                val currentStatHeight =
                    statBarContainerHeight * (stat.value.toDouble() / higherStat.toDouble()).toFloat()

                val distanceBetweenStatBarAndContainer = statBarContainerHeight - currentStatHeight
                val currentStatBarYCoordinate =
                    containerStartCoordinates.y + statBarContainerHeightPercentage

                val currentStatBarPosition = Offset(
                    x = currentStatBarXCoordinate + ((statContainerSize.width / 2) - (statBarWidth / 2)),
                    y = currentStatBarYCoordinate + distanceBetweenStatBarAndContainer
                )

                val currentStatValuePosition = Offset(
                    x = currentStatBarXCoordinate + ((statContainerSize.width / 2) - (statBarWidth / 2)),
                    y = (currentStatBarYCoordinate + distanceBetweenStatBarAndContainer) - textSize
                )

                drawIntoCanvas {
                    it.nativeCanvas.drawText(
                        "${stat.value}",
                        currentStatValuePosition.x,
                        currentStatValuePosition.y,
                        TextPaint().apply {
                            color =
                                currentStatColor(index, colors).toArgb()
                            setTextSize(textSize)
                            // typeface = font
                        }
                    )
                }

                drawRoundRect(
                    color = currentStatColor(index, colors),
                    topLeft = currentStatBarPosition,
                    size = Size(statBarWidth, currentStatHeight),
                    cornerRadius = StatBarCornerRadius
                )

                currentStatBarXCoordinate += statBarWidthInCurrentDensity
            }
        }

        Column(
            modifier = Modifier
                .padding(start = MaterialTheme.Dimensions.Small)
                .align(Alignment.Start)
                .wrapContentWidth()
        ) {
            stats.mapIndexed { index, stat ->
                Row(Modifier.padding(vertical = MaterialTheme.Dimensions.ExtraSmall)) {
                    Box(
                        Modifier
                            .size(20.dp)
                            .background(
                                currentStatColor(index, colors = colors),
                                shape = CircleShape
                            )
                    )
                    Text(
                        text = stat.name.capitalize(Locale.getDefault()),
                        style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onBackground)
                    )
                }
            }
        }
    }
}

private fun currentStatColor(
    index: Int,
    colors: List<Color>
) = colors[
    if (index >= colors.size) {
        index - colors.size
    } else {
        index
    }
]

@Preview
@Composable
fun Preview() {
    PokeDeskTheme {
        Row() {
            StatsChart(
                stats = setOf(
                    PokemonDetail.Stat(1, "attack", 30),
                    PokemonDetail.Stat(2, "health", 58),
                    PokemonDetail.Stat(2, "power", 15),
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.background)
                    .weight(.5f),
                statBarHeight = 170.dp
            )

            StatsChart(
                stats = setOf(
                    PokemonDetail.Stat(2, "love", 70),
                    PokemonDetail.Stat(2, "peace", 56),
                    PokemonDetail.Stat(2, "awesomes", 23)
                ),
                modifier = Modifier
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.background)
                    .weight(.5f),
                statBarHeight = 170.dp
            )
        }
    }
}

private fun Set<PokemonDetail.Stat>.getHigherStat() = maxOf {
    it.value
}

private const val StatsGroups = 2
private const val MaximumStatsPerGroup = 3
private const val StatBarContainerWidth = 40
private const val StatBarDefaultWidth = 20
private val StatBarCornerRadius = CornerRadius(30f, 30f)
private const val StatBarPadding = 50f
private const val StatHalfPadding = StatBarPadding / 2
