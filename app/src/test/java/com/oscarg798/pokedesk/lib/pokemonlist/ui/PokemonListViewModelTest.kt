package com.oscarg798.pokedesk.lib.pokemonlist.ui

import app.cash.turbine.test
import com.oscarg798.pokedesk.lib.PokemonGenerator
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import com.oscarg798.pokedesk.lib.generateRandomValue
import com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel
import com.oscarg798.pokedesk.pokemonlist.usecase.FetchPokemons
import com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems
import io.mockk.Called
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonListViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val getPokemonListItems: GetPokemonListItems = mockk()

    private val fetchPokemons: FetchPokemons = mockk()

    private val coroutineContextProvider = object : CoroutineContextProvider {
        override val io: CoroutineContext
            get() = testDispatcher
        override val computation: CoroutineContext
            get() = testDispatcher
        override val main: CoroutineContext
            get() = testDispatcher
    }
    private lateinit var viewModel: PokemonListViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        viewModel = PokemonListViewModel(
            getPokemonListItems = getPokemonListItems,
            fetchPokemons = fetchPokemons,
            coroutineContextProvider = coroutineContextProvider
        )
    }

    @Test
    fun `when view model is created and get pokemons return items then only items emitted`() =
        runTest {
            val pokemonListItems = PokemonGenerator.generatePokemonListItems()
            every { getPokemonListItems() } answers { flowOf(pokemonListItems) }

            viewModel.state.test {
                Assert.assertEquals(
                    PokemonListViewModel.State(
                        loading = false,
                        currentSearchQuery = "",
                        pokemonListItems = pokemonListItems
                    ),
                    awaitItem()
                )
            }

            coVerify(exactly = 1) {
                getPokemonListItems()
                fetchPokemons wasNot Called
            }
        }

    @Test
    fun `when view model is created and get pokemons return no items then loading emitted fetched called`() =
        runTest {
            every { getPokemonListItems() } answers { flowOf(listOf()) }
            coEvery { fetchPokemons(0) } just Runs

            viewModel.state.test {
                Assert.assertEquals(
                    PokemonListViewModel.State(
                        loading = true,
                        currentSearchQuery = "",
                        pokemonListItems = null
                    ),
                    awaitItem()
                )
                Assert.assertEquals(
                    PokemonListViewModel.State(
                        loading = false,
                        currentSearchQuery = "",
                        pokemonListItems = null
                    ),
                    awaitItem()
                )
            }

            coVerify(exactly = 1) {
                getPokemonListItems()
                fetchPokemons(0)
            }
        }

    @Test
    fun `when fetch pokemons called then it should get pokemons based on the size of curretn state`() =
        runTest {
            val pokemonListItems = PokemonGenerator.generatePokemonListItems()
            every { getPokemonListItems() } answers { flowOf(pokemonListItems) }
            coEvery { fetchPokemons(pokemonListItems.size) } just Runs

            advanceTimeBy(1_000)
            viewModel.fetchPokemonListItems()

            viewModel.state.test {
                Assert.assertEquals(
                    PokemonListViewModel.State(
                        loading = false,
                        currentSearchQuery = "",
                        pokemonListItems = pokemonListItems
                    ),
                    awaitItem()
                )
                Assert.assertEquals(
                    PokemonListViewModel.State(
                        loading = true,
                        currentSearchQuery = "",
                        pokemonListItems = pokemonListItems
                    ),
                    awaitItem()
                )
                Assert.assertEquals(
                    PokemonListViewModel.State(
                        loading = false,
                        currentSearchQuery = "",
                        pokemonListItems = pokemonListItems
                    ),
                    awaitItem()
                )
            }

            coVerify(exactly = 1) {
                getPokemonListItems()
                fetchPokemons(pokemonListItems.size)
            }
        }

    @Test
    fun `when query is updated then state should reflect it`() = runTest {
        val pokemonListItems = PokemonGenerator.generatePokemonListItems()
        every { getPokemonListItems() } answers { flowOf(pokemonListItems) }
        val query = generateRandomValue<String>(String::class.java)

        advanceTimeBy(1_000)
        viewModel.onQueryUpdated(query)

        viewModel.state.test {
            Assert.assertEquals(
                PokemonListViewModel.State(
                    loading = false,
                    currentSearchQuery = "",
                    pokemonListItems = pokemonListItems
                ),
                awaitItem()
            )
            Assert.assertEquals(
                PokemonListViewModel.State(
                    loading = false,
                    currentSearchQuery = query,
                    pokemonListItems = pokemonListItems
                ),
                awaitItem()
            )
        }
    }
}
