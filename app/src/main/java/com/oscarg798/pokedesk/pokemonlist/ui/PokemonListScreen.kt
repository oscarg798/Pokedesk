package com.oscarg798.pokedesk.pokemonlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.oscarg798.pokedesk.lib.navigation.composable
import com.oscarg798.pokedesk.lib.ui.Dimensions
import com.oscarg798.pokedesk.lib.ui.LocalAppDimens
import com.oscarg798.pokedesk.pokemonlist.navigation.PokemonListRoute

fun NavGraphBuilder.pokemonScreen() = composable(route = PokemonListRoute) {
    val viewModel: PokemonListViewModel = hiltViewModel(it)

    val state: PokemonListViewModel.State by viewModel.state.collectAsState(PokemonListViewModel.State())

    Scaffold(topBar = {
        SearchBar(
            search = { viewModel.onSearch() },
            onQueryUpdated = { submittedQuery ->
                viewModel.onQueryUpdated(query = submittedQuery)
            }, currentQuery = state.currentSearchQuery,
            modifier = Modifier.fillMaxWidth()
                .padding(MaterialTheme.Dimensions.Small)
        )
    }) {
        if (state.pokemonListItems != null) {
            val pokemonListItems = state.pokemonListItems!!
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(LocalAppDimens.current.Small),
                contentPadding = PaddingValues(LocalAppDimens.current.Medium)
            ) {
                items(pokemonListItems, key = { item ->
                    item.id
                }) { item ->
                    PokemonListCard(pokemon = item)
                }
            }
        }
    }
}