package com.oscarg798.pokedesk.pokemonlist.ui

import com.oscarg798.pokedesk.lib.definitions.AbstractViewModel
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import com.oscarg798.pokedesk.lib.definitions.launch
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.withContext
import javax.inject.Inject

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

    private fun fetchPokemonListItems() {
        launch {
            update { it.copy(loading = true) }
            val pokemonListItems = withContext(io) {
                getPokemonListItems()
            }

            update { it.copy(loading = false, pokemonListItems = pokemonListItems) }
        }
    }

    fun onQueryUpdated(query: String){
        updateSync { it.copy(currentSearchQuery = query) }
    }

    fun onSearch(){
        //TODO: actually search based on https://github.com/oscarg798/Pokedesk/projects/1#card-76490485
    }

    data class State(
        val loading: Boolean = false,
        val currentSearchQuery: String = EmptyQuery,
        val pokemonListItems: List<PokemonListItem>? = null
    )

    sealed interface Event
}

private const val EmptyQuery = ""