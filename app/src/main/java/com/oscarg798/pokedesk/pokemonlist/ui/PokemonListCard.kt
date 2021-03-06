package com.oscarg798.pokedesk.pokemonlist.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.oscarg798.pokedesk.R
import com.oscarg798.pokedesk.lib.type.ui.TypeChip
import com.oscarg798.pokedesk.lib.ui.Dimensions
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.skydoves.landscapist.fresco.FrescoImage

@Composable
fun PokemonListCard(pokemon: PokemonListItem, onItemClicked: (Int) -> Unit) {
    Card(
        shape = RoundedCornerShape(MaterialTheme.Dimensions.Medium),
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onItemClicked(pokemon.id)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .padding(MaterialTheme.Dimensions.Medium)
                    .weight(.6f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = pokemon.name.capitalize(Locale.current),
                    style = MaterialTheme.typography.h2.copy(
                        color = MaterialTheme.colors.onSurface
                    )
                )
                Row(
                    modifier = Modifier
                        .padding(top = MaterialTheme.Dimensions.Small)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_pokeball_color),
                        contentDescription = "Pokeball icon",
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "#${pokemon.id}",
                        modifier = Modifier.padding(start = MaterialTheme.Dimensions.ExtraSmall),
                        style = MaterialTheme.typography.body1.copy(
                            color = MaterialTheme.colors.onSurface
                        )
                    )
                }

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = MaterialTheme.Dimensions.Small),
                    crossAxisSpacing = MaterialTheme.Dimensions.ExtraSmall,
                    content = {
                        pokemon.types.map {
                            TypeChip(
                                typeName = it.name,
                                typeColor = it.color,
                                modifier = Modifier.padding(horizontal = MaterialTheme.Dimensions.ExtraSmall)
                            )
                        }
                    }
                )
            }

            Box(
                modifier = Modifier
                    .weight(.4f)
                    .height(120.dp)
            ) {
                FrescoImage(
                    imageUrl = pokemon.image,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
