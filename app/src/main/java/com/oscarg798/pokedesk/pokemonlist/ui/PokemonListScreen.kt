package com.oscarg798.pokedesk.pokemonlist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer
import com.oscarg798.pokedesk.R
import com.oscarg798.pokedesk.detail.navigation.PokemonDetailRoute
import com.oscarg798.pokedesk.lib.navigation.composable
import com.oscarg798.pokedesk.lib.ui.Dimensions
import com.oscarg798.pokedesk.lib.ui.LocalAppDimens
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.navigation.PokemonListRoute
import kotlinx.coroutines.launch

fun NavGraphBuilder.pokemonScreen(navController: NavController) =
    composable(route = PokemonListRoute) {
        val viewModel: PokemonListViewModel = hiltViewModel(it)

        val state: PokemonListViewModel.State by viewModel.state.collectAsState(PokemonListViewModel.State())
        val events: PokemonListViewModel.Event? by viewModel.events.collectAsState(initial = null)

        LaunchedEffect(key1 = events) {
            val event = events ?: return@LaunchedEffect

            if (event !is PokemonListViewModel.Event.NavigateToDetail) {
                return@LaunchedEffect
            }

            PokemonDetailRoute.navigate(event.id, navController)
        }

        Scaffold(
            topBar = {
                SearchBar(
                    search = { viewModel.onSearch() },
                    onQueryUpdated = { submittedQuery ->
                        viewModel.onQueryUpdated(query = submittedQuery)
                    },
                    currentQuery = state.currentSearchQuery,
                    enabled = false,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MaterialTheme.Dimensions.Small)
                )
            }
        ) {
            when {
                state.loading && state.pokemonListItems == null -> LoadingList()
                state.pokemonListItems != null -> PokemonList(
                    pokemonListItems = state.pokemonListItems!!,
                    loading = state.loading,
                    onBottomReached = {
                        viewModel.fetchPokemonListItems()
                    }
                ) { id ->
                    Int
                    viewModel.onItemClicked(id)
                }
            }
        }
    }

@Composable
private fun LoadingList() {
    PokemonListLazyColumn(modifier = Modifier.fillMaxSize()) {
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
private fun PokemonList(
    pokemonListItems: List<PokemonListItem>,
    loading: Boolean,
    onBottomReached: () -> Unit,
    onItemClicked: (Int) -> Unit
) {

    val coroutineScope = rememberCoroutineScope()

    val listState = rememberLazyListState()

    val endOfListReached by remember {
        derivedStateOf {
            listState.isScrolledToEnd()
        }
    }

    val goToTopButtonVisibility by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 2
        }
    }

    LaunchedEffect(endOfListReached) {
        if (endOfListReached && !loading) {
            onBottomReached()
        }
    }

    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.weight(
                if (loading) {
                    0.9f
                } else {
                    1f
                }
            )
        ) {
            PokemonListLazyColumn(
                listState = listState,
                modifier = Modifier.fillMaxSize()
            ) {
                items(
                    pokemonListItems,
                    key = { item ->
                        item.id
                    }
                ) { item ->
                    PokemonListCard(pokemon = item) {
                        onItemClicked(it)
                    }
                }
            }

            if (goToTopButtonVisibility) {
                IconButton(
                    modifier = Modifier
                        .padding(
                            end = LocalAppDimens.current.Medium,
                            bottom = LocalAppDimens.current.Large
                        )
                        .align(Alignment.BottomEnd)
                        .background(
                            MaterialTheme.colors.secondary.copy(alpha = .5f),
                            shape = CircleShape
                        )
                        .size(50.dp),
                    onClick = {
                        coroutineScope.launch { listState.scrollToItem(FirstItem) }
                    }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_up),
                        contentDescription = "Go to the top of the list",
                        tint = MaterialTheme.colors.onSecondary,
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
        if (loading) {
            LoadingMoreContent(
                Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = LocalAppDimens.current.Medium)
            )
        }
    }
}

@Composable
private fun LoadingMoreContent(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        CircularProgressIndicator(
            Modifier
                .size(20.dp)
        )

        Text(
            text = "Loading more pokemons",
            style = MaterialTheme.typography.body1.copy(
                color = MaterialTheme.colors.onBackground
            ),
            modifier = Modifier.padding(start = LocalAppDimens.current.Small)
        )
    }
}

@Composable
private fun PokemonListLazyColumn(
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState(),
    content: LazyListScope.() -> Unit
) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(LocalAppDimens.current.Small),
        contentPadding = PaddingValues(LocalAppDimens.current.Medium),
        state = listState
    ) {
        content()
    }
}

private val FirstItem = 0
private fun LazyListState.isScrolledToEnd() = layoutInfo.totalItemsCount > 0 &&
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
