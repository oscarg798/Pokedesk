package com.oscarg798.pokedesk.lib.pokemoncardimages

import app.cash.turbine.test
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import com.oscarg798.pokedesk.pokemoncardimages.PokemonCardImagesViewModel
import com.oscarg798.pokedesk.pokemoncardimages.usecase.GetPokemonCardImages
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import java.util.UUID
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonCardImagesViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private val coroutineContextProvider = object : CoroutineContextProvider {
        override val io: CoroutineContext
            get() = testDispatcher
        override val computation: CoroutineContext
            get() = testDispatcher
        override val main: CoroutineContext
            get() = testDispatcher
    }

    private val getPokemonCardImages: GetPokemonCardImages = mockk()
    private lateinit var viewModel: PokemonCardImagesViewModel
    private lateinit var pokemonName: String

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        pokemonName = UUID.randomUUID().toString()
        viewModel = PokemonCardImagesViewModel(
            pokemonName = pokemonName,
            getPokemonCardImages = getPokemonCardImages,
            coroutineContextProvider = coroutineContextProvider
        )
    }

    @Test
    fun `given pokemonname when init then it should get pokemon images`() = runTest {
        val images = PokemonCardImagesGenerator.generateCardImages()
        coEvery { getPokemonCardImages(pokemonName) } answers { images }

        viewModel.state.test {
            Assert.assertEquals(
                PokemonCardImagesViewModel.ViewState(
                    loading = true,
                    cardImages = null
                ),
                awaitItem()
            )
            Assert.assertEquals(
                PokemonCardImagesViewModel.ViewState(
                    loading = false,
                    cardImages = images
                ),
                awaitItem()
            )
        }

        coVerify(exactly = 1) { getPokemonCardImages(pokemonName) }
    }

    @Test
    fun `when onCardImageClicked then it should emit OpenCardImageDetail with the card url`() = runTest {
        val images = PokemonCardImagesGenerator.generateCardImages()
        val image = images.first()
        coEvery { getPokemonCardImages(pokemonName) } answers { images }

        viewModel.events.test {
            viewModel.onCardImageClicked(image)

            Assert.assertEquals(
                PokemonCardImagesViewModel.Event.OpenCardImageDetail(image.images.large),
                awaitItem()
            )
        }
    }
}
