package com.oscarg798.pokedesk.pokemonlist.ui

import com.oscarg798.pokedesk.lib.definitions.AbstractViewModel
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import com.oscarg798.pokedesk.lib.definitions.launch
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.usecase.FetchPokemons
import com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListItems: GetPokemonListItems,
    private val fetchPokemons: FetchPokemons,
    coroutineContextProvider: CoroutineContextProvider
) : AbstractViewModel<PokemonListViewModel.State, PokemonListViewModel.Event>(
    initialState = State(),
    coroutineContextProvider = coroutineContextProvider
) {

    init {
        getPokemons()
    }

    fun fetchPokemonListItems() {
        launch {
            update { it.copy(loading = true) }

            val currentState = currentState()

            withContext(io) {
                fetchPokemons(currentState.pokemonListItems?.size ?: DefaultOffset)
            }

            update {
                it.copy(loading = false)
            }
        }
    }

    private fun getPokemons() {
        launch {
            getPokemonListItems()
                .flowOn(io)
                .collect { pokemonListItems ->
                    if (pokemonListItems.isEmpty()) {
                        fetchPokemonListItems()
                    } else {
                        update {
                            it.copy(pokemonListItems = pokemonListItems, loading = false)
                        }
                    }
                }
        }
    }

    fun onItemClicked(id: Int) {
        _event.tryEmit(Event.NavigateToDetail(id))
    }

    fun onQueryUpdated(query: String) {
        updateSync { it.copy(currentSearchQuery = query) }
    }

    fun onSearch() {
        // TODO: actually search based on https://github.com/oscarg798/Pokedesk/projects/1#card-76490485
    }

    data class State(
        val loading: Boolean = true,
        val currentSearchQuery: String = EmptyQuery,
        val pokemonListItems: List<PokemonListItem>? = null
    )

    sealed interface Event {
        data class NavigateToDetail(val id: Int) : Event
    }
}

private const val EmptyQuery = ""
private const val DefaultOffset = 0
