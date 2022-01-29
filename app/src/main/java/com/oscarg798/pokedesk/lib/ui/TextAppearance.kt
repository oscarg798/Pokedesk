package com.oscarg798.pokedesk.lib.ui

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.oscarg798.pokedesk.R

private val fontFamily = FontFamily(
    Font(resId = R.font.cabin_regular, weight = FontWeight.Light),
    Font(resId = R.font.cabin_regular, weight = FontWeight.Normal),
    Font(resId = R.font.cabin_bold, weight = FontWeight.Bold)
)

interface FontSizes {

    val H1: TextUnit
    val H2: TextUnit
    val H3: TextUnit
    val H4: TextUnit
    val Body1: TextUnit
    val Body2: TextUnit
    val Subtitle1FontSize: TextUnit
    val Subtitle2FontSize: TextUnit
}

val smallFontSizes = object : FontSizes {
    override val H1: TextUnit
        get() = 24.sp
    override val H2: TextUnit
        get() = 20.sp
    override val H3: TextUnit
        get() = 14.sp
    override val H4: TextUnit
        get() = 12.sp
    override val Body1: TextUnit
        get() = 12.sp
    override val Body2: TextUnit
        get() = 10.sp
    override val Subtitle1FontSize: TextUnit
        get() = 12.sp
    override val Subtitle2FontSize: TextUnit
        get() = 10.sp
}

val normalFontSizes = object : FontSizes {
    override val H1: TextUnit
        get() = 28.sp
    override val H2: TextUnit
        get() = 24.sp
    override val H3: TextUnit
        get() = 16.sp
    override val H4: TextUnit
        get() = 14.sp
    override val Body1: TextUnit
        get() = 14.sp
    override val Body2: TextUnit
        get() = 12.sp
    override val Subtitle1FontSize: TextUnit
        get() = 14.sp
    override val Subtitle2FontSize: TextUnit
        get() = 12.sp
}

fun getTypography(fontSizes: FontSizes): Typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = fontSizes.H1,
        letterSpacing = (-1.5).sp,
        fontFamily = fontFamily
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = fontSizes.H2,
        fontFamily = fontFamily
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = fontSizes.H3,
        fontFamily = fontFamily
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = fontSizes.H4,
        fontFamily = fontFamily
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = fontSizes.H4,
        fontFamily = fontFamily
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = fontSizes.H4,
        fontFamily = fontFamily
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = fontSizes.Subtitle1FontSize,
        fontFamily = fontFamily
    ),
    subtitle2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = fontSizes.Subtitle2FontSize,
        fontFamily = fontFamily
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = fontSizes.Body1,
        fontFamily = fontFamily
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = fontSizes.Body2,
        fontFamily = fontFamily
    )
)
