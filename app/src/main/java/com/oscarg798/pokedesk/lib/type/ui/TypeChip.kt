package com.oscarg798.pokedesk.lib.type.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import com.oscarg798.pokedesk.lib.isDarkColor
import com.oscarg798.pokedesk.lib.ui.Dimensions

@Composable
fun TypeChip(
    typeName: String,
    typeColor: Color,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle()
) {
    Card(
        shape = RoundedCornerShape(MaterialTheme.Dimensions.Small),
        modifier = modifier.wrapContentSize(),
        backgroundColor = typeColor
    ) {
        Text(
            text = typeName.capitalize(Locale.current),
            Modifier.padding(
                vertical = MaterialTheme.Dimensions.ExtraSmall,
                horizontal = MaterialTheme.Dimensions.Small
            ),
            style = textStyle.copy(
                color = if (typeColor.isDarkColor()) {
                    Color.White
                } else {
                    Color.Black
                }
            )
        )
    }
}
