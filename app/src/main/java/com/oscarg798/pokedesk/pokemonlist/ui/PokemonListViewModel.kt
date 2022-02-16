package com.oscarg798.pokedesk.pokemonlist.ui

import com.oscarg798.pokedesk.lib.definitions.AbstractViewModel
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import com.oscarg798.pokedesk.lib.definitions.launch
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.withContext

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListItems: GetPokemonListItems,
    coroutineContextProvider: CoroutineContextProvider
) : AbstractViewModel<PokemonListViewModel.State, PokemonListViewModel.Event>(
    initialState = State(),
    coroutineContextProvider = coroutineContextProvider
) {

    init {
        fetchPokemonListItems()
    }

    fun fetchPokemonListItems() {
        launch {
            update { it.copy(loading = true) }

            val currentState = currentState()

            val pokemonListItems = withContext(io) {
                getPokemonListItems(currentState.pokemonListItems?.size ?: 0)
            }

            update {
                it.copy(
                    loading = false,
                    pokemonListItems = (
                        currentState.pokemonListItems
                            ?: emptyList()
                        ) + pokemonListItems
                )
            }
        }
    }

    fun onQueryUpdated(query: String) {
        updateSync { it.copy(currentSearchQuery = query) }
    }

    fun onSearch() {
        // TODO: actually search based on https://github.com/oscarg798/Pokedesk/projects/1#card-76490485
    }

    data class State(
        val loading: Boolean = false,
        val currentSearchQuery: String = EmptyQuery,
        val pokemonListItems: List<PokemonListItem>? = null
    )

    sealed interface Event
}

private const val EmptyQuery = ""
