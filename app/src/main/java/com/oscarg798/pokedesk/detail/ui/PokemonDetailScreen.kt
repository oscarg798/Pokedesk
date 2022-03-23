package com.oscarg798.pokedesk.detail.ui

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.flowlayout.FlowRow
import com.oscarg798.pokedesk.LocalNavControllerProvider
import com.oscarg798.pokedesk.R
import com.oscarg798.pokedesk.detail.model.PokemonDetail
import com.oscarg798.pokedesk.detail.navigation.PokemonDetailRoute
import com.oscarg798.pokedesk.lib.ViewModelStore
import com.oscarg798.pokedesk.lib.navigation.composable
import com.oscarg798.pokedesk.lib.type.ui.TypeChip
import com.oscarg798.pokedesk.lib.ui.Dimensions
import com.skydoves.landscapist.fresco.FrescoImage
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent
import java.util.Locale

fun NavGraphBuilder.pokemonDetailScreen(
    viewModelStore: ViewModelStore
) = composable(
    route = PokemonDetailRoute,
    arguments = listOf(
        navArgument(PokemonDetailRoute.IdArgument) { type = NavType.IntType }
    )
) { backStackEntry ->

    val activity = LocalContext.current as Activity
    val id = backStackEntry.arguments!!
        .getInt(PokemonDetailRoute.IdArgument)
    val navController = LocalNavControllerProvider.current

    val viewModel: PokemonDetailViewModel = viewModelStore.get("${PokemonDetailKey}_$id") {
        getViewModel(id, activity)
    } as PokemonDetailViewModel

    val state = viewModel.state.collectAsState(initial = PokemonDetailViewModel.State())

    val pokemon = state.value.pokemon ?: return@composable

    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.Dimensions.Medium),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "back",
                    tint = MaterialTheme.colors.onSurface.copy(alpha = .5f),
                    modifier = Modifier
                        .size(30.dp)
                        .weight(.1f)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Text(
                    text = pokemon.name.capitalize(Locale.getDefault()),
                    style = MaterialTheme.typography.h2.copy(color = MaterialTheme.colors.onSurface),
                    modifier = Modifier
                        .padding(start = MaterialTheme.Dimensions.Large)
                        .weight(.9f)
                )
                Icon(
                    painterResource(R.drawable.ic_pokeball_grayscale),
                    contentDescription = null,
                    tint = MaterialTheme.colors.onSurface.copy(.5f),
                    modifier = Modifier
                        .size(20.dp)
                        .weight(.1f)
                )
            }
        }
    ) {
        Column(
            Modifier
                .verticalScroll(scrollState)
                .fillMaxWidth()
                .padding(MaterialTheme.Dimensions.Medium)
        ) {
            PokemonDetailImage(
                image = pokemon.image,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            PokemonTypes(
                types = pokemon.types,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.Dimensions.Small)
            )

            PokemonCharacteristics(
                pokemon = pokemon,
                modifier = Modifier
                    .padding(top = MaterialTheme.Dimensions.Medium)
            )

            if (pokemon.stats.isNotEmpty()) {
                PokemonStats(
                    stats = pokemon.stats,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun PokemonTypes(
    types: Set<PokemonDetail.Type>,
    modifier: Modifier
) {
    FlowRow(
        modifier = modifier,
        crossAxisSpacing = MaterialTheme.Dimensions.ExtraSmall,
        content = {
            types.map {
                TypeChip(
                    typeName = it.name,
                    typeColor = it.color,
                    textStyle = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.Dimensions.ExtraSmall)
                )
            }
        }
    )
}

@Composable
private fun PokemonDetailImage(image: String, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        FrescoImage(
            imageUrl = image,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
    }
}

private fun getViewModel(
    id: Int,
    activity: Activity
): PokemonDetailViewModel = EntryPointAccessors.fromActivity(
    activity = activity,
    entryPoint = PokemonDetailEntryPoint::class.java
).pokemonDetailFactory().create(id)

@EntryPoint
@InstallIn(ActivityComponent::class)
internal interface PokemonDetailEntryPoint {

    fun pokemonDetailFactory(): PokemonDetailViewModel.Factory
}

const val PokemonDetailKey = "PokemonDetailKey"
