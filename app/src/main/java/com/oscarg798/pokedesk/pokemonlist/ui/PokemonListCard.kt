package com.oscarg798.pokedesk.pokemonlist.ui

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.oscarg798.pokedesk.R
import com.oscarg798.pokedesk.pokemonlist.PokemonListItem
import com.skydoves.landscapist.fresco.FrescoImage

@Composable
fun PokemonListCard(pokemon: PokemonListItem) {

    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color(0xff323232),
        contentColor = Color(0xff323232),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(.6f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = pokemon.name.capitalize(Locale.current),
                    style = TextStyle(color = Color.White, fontWeight = FontWeight.Medium)
                )
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_pokeball_color),
                        contentDescription = "Pokeball icon",
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "#${pokemon.order}", modifier = Modifier.padding(start = 4.dp),
                        style = TextStyle(color = Color.White)
                    )
                }

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    crossAxisSpacing = 4.dp,
                    content = {
                        pokemon.types.map {
                            TypeChip(type = it, modifier = Modifier.padding(horizontal = 4.dp))
                        }
                    })
            }

            Box(   modifier = Modifier
                .weight(.4f)
                .height(120.dp)) {
                FrescoImage(
                    imageUrl = pokemon.image,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

    }
}

@Composable
private fun TypeChip(type: PokemonListItem.Type, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.wrapContentSize(),
        backgroundColor = type.color
    ) {
        Text(
            text = type.name.capitalize(Locale.current),
            Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
            style = TextStyle(
                color = if (type.color.isDarkColor()) {
                    Color.White
                } else {
                    Color.Black
                }
            )
        )
    }
}

private fun Color.isDarkColor(): Boolean {
    return luminance() < DarkColorLuminanceThreshold
}

private const val DarkColorLuminanceThreshold = .5