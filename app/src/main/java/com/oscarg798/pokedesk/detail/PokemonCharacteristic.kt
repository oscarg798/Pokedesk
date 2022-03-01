package com.oscarg798.pokedesk.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.oscarg798.pokedesk.lib.ui.Dimensions

@Composable
internal fun PokemonCharacteristics(pokemon: PokemonDetail, modifier: Modifier) {
    Column(modifier.fillMaxWidth()) {
        Text(
            text = "About:",
            style = MaterialTheme.typography.h2.copy(
                color = MaterialTheme.colors.onBackground
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = MaterialTheme.Dimensions.Small)
        )

        Row(
            Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            PokemonCharacteristic(
                value = "${pokemon.height} m",
                label = "Height",
                modifier = Modifier
                    .padding(start = MaterialTheme.Dimensions.Small)
            )
            PokemonCharacteristic(
                value = "${pokemon.weight} kg",
                label = "Weight",
                modifier = Modifier
                    .padding(start = MaterialTheme.Dimensions.Small)
            )
        }
    }
}

@Composable
private fun PokemonCharacteristic(
    value: String,
    label: String,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.surface,
    ) {
        Row(
            Modifier
                .padding(MaterialTheme.Dimensions.Medium),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$label:",
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onBackground)
            )
            Text(
                text = value,
                style = MaterialTheme.typography.body2.copy(color = MaterialTheme.colors.onBackground)
            )
        }
    }
}
