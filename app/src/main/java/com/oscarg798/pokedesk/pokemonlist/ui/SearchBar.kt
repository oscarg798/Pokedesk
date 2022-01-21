package com.oscarg798.pokedesk.pokemonlist.ui

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.oscarg798.pokedesk.R
import com.oscarg798.pokedesk.lib.ui.Dimensions
import com.oscarg798.pokedesk.lib.ui.SecondaryTextColor

@Composable
fun SearchBar(
    onQueryUpdated: (String) -> Unit,
    currentQuery: String,
    search: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier,
        value = currentQuery,
        onValueChange = onQueryUpdated,
        shape = RoundedCornerShape(MaterialTheme.Dimensions.Medium),
        maxLines = SingleLine,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            search()
        }),
        placeholder = {
            Text(
                text = stringResource(R.string.search_hint),
                style = MaterialTheme.typography.subtitle1.copy(color = SecondaryTextColor)
            )
        },
        textStyle = MaterialTheme.typography.subtitle1,
        trailingIcon = {
            Icon(
                painterResource(R.drawable.ic_pokeball_grayscale),
                contentDescription = null,
                tint = MaterialTheme.colors.primary,
                modifier = Modifier.size(20.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            textColor = MaterialTheme.colors.onSurface
        )
    )
}

private const val SingleLine = 1