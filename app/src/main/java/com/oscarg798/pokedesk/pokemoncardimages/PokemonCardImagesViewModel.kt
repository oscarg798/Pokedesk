package com.oscarg798.pokedesk.pokemoncardimages

import com.oscarg798.pokedesk.lib.definitions.AbstractViewModel
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import com.oscarg798.pokedesk.lib.definitions.launch
import com.oscarg798.pokedesk.pokemoncardimages.model.PokemonCardImages
import com.oscarg798.pokedesk.pokemoncardimages.usecase.GetPokemonCardImages
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.withContext

class PokemonCardImagesViewModel @AssistedInject constructor(
    @Assisted
    private val pokemonName: String,
    private val getPokemonCardImages: GetPokemonCardImages,
    coroutineContextProvider: CoroutineContextProvider,
) : AbstractViewModel<PokemonCardImagesViewModel.ViewState, PokemonCardImagesViewModel.Event>(
    ViewState(),
    coroutineContextProvider
) {

    init {
        fetchPokemonCardImages()
    }

    private fun fetchPokemonCardImages() {
        launch {
            update { it.copy(loading = true) }
            val cardImages = withContext(io) {
                getPokemonCardImages(pokemonName)
            }
            update { it.copy(loading = false, cardImages = cardImages) }
        }
    }

    fun onCardImageClicked(cardImages: PokemonCardImages) {
        _event.tryEmit(Event.OpenCardImageDetail(cardImages.images.large))
    }

    data class ViewState(
        val loading: Boolean = false,
        val cardImages: List<PokemonCardImages>? = null
    )

    sealed interface Event {

        data class OpenCardImageDetail(
            val cardImageUrl: String
        ) : Event
    }

    @AssistedFactory
    interface PokemonCardImagesFactory {

        fun create(pokemonName: String): PokemonCardImagesViewModel
    }
}
