package com.oscarg798.pokedesk.pokemoncardimages

import android.app.Activity
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.with
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.oscarg798.pokedesk.lib.LocalViewModelStore
import com.oscarg798.pokedesk.lib.shimmer
import com.oscarg798.pokedesk.lib.ui.Dimensions
import com.skydoves.landscapist.fresco.FrescoImage
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent

@Composable
fun PokemonCardImagesScreen(
    pokemonName: String,
    modifier: Modifier = Modifier
) {

    val viewModelStore = LocalViewModelStore.current

    val activity = LocalContext.current as Activity

    val viewModel: PokemonCardImagesViewModel =
        viewModelStore.get("${PokemonCardImagesKey}_$pokemonName") {
            getViewModel(pokemonName, activity)
        } as PokemonCardImagesViewModel

    val state by viewModel.state.collectAsState(initial = PokemonCardImagesViewModel.ViewState())
    val events by viewModel.events.collectAsState(initial = null)

    val cardImageUrlToShow = remember {
        mutableStateOf<String?>(null)
    }

    LaunchedEffect(key1 = events) {
        val event = events ?: return@LaunchedEffect

        if (event is PokemonCardImagesViewModel.Event.OpenCardImageDetail) {
            cardImageUrlToShow.value = event.cardImageUrl
        }
    }

    Column(modifier) {

        Text(
            text = "TCG Cards:",
            style = MaterialTheme.typography.h2.copy(
                color = MaterialTheme.colors.onBackground
            ),
            modifier = Modifier
        )

        AnimatedContent(
            targetState = state,
            transitionSpec = {
                fadeIn(animationSpec = tween(220, delayMillis = 50)) +
                    scaleIn(initialScale = 0.92f, animationSpec = tween(220, delayMillis = 50)) with
                    fadeOut(animationSpec = tween(90))
            }
        ) {

            with(state) {
                if (loading) {
                    CardImagesContainer(
                        Modifier
                            .padding(bottom = MaterialTheme.Dimensions.Small)
                    ) {
                        items((0 until 5).toList()) {
                            Box(
                                Modifier
                                    .width(150.dp)
                                    .height(CardHeight)
                                    .shimmer()
                            ) { }
                        }
                    }
                } else if (cardImages != null) {
                    val cardImages = state.cardImages ?: return@AnimatedContent

                    CardImagesContainer(
                        Modifier
                            .padding(bottom = MaterialTheme.Dimensions.Small)
                    ) {
                        items(cardImages, key = { it.id }) { cardImage ->
                            Box(
                                modifier = Modifier
                                    .height(CardHeight)
                                    .combinedClickable(
                                        onDoubleClick = {
                                            viewModel.onCardImageClicked(cardImage)
                                        },
                                        enabled = true, onClick = {}
                                    )
                            ) {
                                FrescoImage(
                                    imageUrl = cardImage.images.large,
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    if (cardImageUrlToShow.value != null) {
        CardDetail(
            modifier = Modifier.fillMaxSize(),
            cardImageUrl = cardImageUrlToShow.value!!
        ) {
            cardImageUrlToShow.value = null
        }
    }
}

@Composable
private fun CardDetail(
    modifier: Modifier,
    cardImageUrl: String,
    onDismiss: () -> Unit
) {

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = modifier.clickable {
                onDismiss()
            }
        ) {
            FrescoImage(
                imageUrl = cardImageUrl,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun CardImagesContainer(
    modifier: Modifier = Modifier,
    content: LazyListScope.() -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.Dimensions.Medium)
    ) {
        content()
    }
}

private fun getViewModel(
    pokemonName: String,
    activity: Activity
): PokemonCardImagesViewModel =
    EntryPointAccessors.fromActivity(activity, PokemonCardImagesFactoryEntryPoint::class.java)
        .provide().create(pokemonName)

@InstallIn(ActivityComponent::class)
@EntryPoint
interface PokemonCardImagesFactoryEntryPoint {

    fun provide(): PokemonCardImagesViewModel.PokemonCardImagesFactory
}

private val CardHeight = 200.dp
private const val PokemonCardImagesKey = "PokemonCardImagesKey"
