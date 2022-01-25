package com.oscarg798.pokedesk.pokemonlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.oscarg798.pokedesk.lib.navigation.composable
import com.oscarg798.pokedesk.lib.ui.Dimensions
import com.oscarg798.pokedesk.lib.ui.LocalAppDimens
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.navigation.PokemonListRoute

fun NavGraphBuilder.pokemonScreen() = composable(route = PokemonListRoute) {
    val viewModel: PokemonListViewModel = hiltViewModel(it)

    val state: PokemonListViewModel.State by viewModel.state.collectAsState(PokemonListViewModel.State())

    Scaffold(
        topBar = {
            SearchBar(
                search = { viewModel.onSearch() },
                onQueryUpdated = { submittedQuery ->
                    viewModel.onQueryUpdated(query = submittedQuery)
                },
                currentQuery = state.currentSearchQuery,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.Dimensions.Small)
            )
        }
    ) {
        when {
            state.loading -> LoadingList()
            state.pokemonListItems != null -> PokemonList(pokemonListItems = state.pokemonListItems!!)
        }
    }
}

@Composable
private fun LoadingList() {
    PokemonListLazyColumn {
        items((0..5).toList()) {
            Card(
                shape = RoundedCornerShape(MaterialTheme.Dimensions.Medium),
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.surface,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .placeholder(
                        visible = true,
                        shape = RoundedCornerShape(MaterialTheme.Dimensions.Medium),
                        color = MaterialTheme.colors.surface,
                        highlight = PlaceholderHighlight.shimmer(highlightColor = Color(0xffcccccc))
                    )
                    .wrapContentHeight()
            ) { }
        }
    }
}

@Composable
private fun PokemonList(pokemonListItems: List<PokemonListItem>) {
    PokemonListLazyColumn {
        items(
            pokemonListItems,
            key = { item ->
                item.id
            }
        ) { item ->
            PokemonListCard(pokemon = item)
        }
    }
}

@Composable
private fun PokemonListLazyColumn(content: LazyListScope.() -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(LocalAppDimens.current.Small),
        contentPadding = PaddingValues(LocalAppDimens.current.Medium)
    ) {
        content()
    }
}
