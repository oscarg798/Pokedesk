package com.oscarg798.pokedesk.detail

import com.oscarg798.pokedesk.lib.definitions.AbstractViewModel
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import com.oscarg798.pokedesk.lib.definitions.launch
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.withContext

class PokemonDetailViewModel @AssistedInject constructor(
    @Assisted private val id: Int,
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
    coroutineContextProvider: CoroutineContextProvider
) : AbstractViewModel<PokemonDetailViewModel.State, PokemonDetailViewModel.Event>(
    State(),
    coroutineContextProvider
) {

    init {
        getDetail()
    }

    private fun getDetail() {
        launch {
            update { it.copy(loading = true) }
            val pokemon = withContext(io) {
                getPokemonDetailUseCase(id)
            }
            update { it.copy(loading = false, pokemon = pokemon) }
        }
    }

    data class State(
        val loading: Boolean = false,
        val pokemon: PokemonDetail? = null
    )

    sealed interface Event

    @AssistedFactory
    interface Factory {
        fun create(id: Int): PokemonDetailViewModel
    }
}
