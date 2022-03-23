// package com.oscarg798.pokedesk.lib.pokemonlist.ui
//
// import androidx.compose.ui.graphics.Color
// import app.cash.turbine.test
// import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
// import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
// import com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel
// import com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems
// import io.mockk.coEvery
// import io.mockk.coVerify
// import io.mockk.mockk
// import kotlin.coroutines.CoroutineContext
// import kotlinx.coroutines.Dispatchers
// import kotlinx.coroutines.test.StandardTestDispatcher
// import kotlinx.coroutines.test.runTest
// import kotlinx.coroutines.test.setMain
// import org.junit.Assert
// import org.junit.Before
// import org.junit.Test
//
// class PokemonListViewModelTest {
//
//    private val testDispatcher = StandardTestDispatcher()
//    private val getPokemonListItems: GetPokemonListItems = mockk()
//
//    private val coroutineContextProvider = object : CoroutineContextProvider {
//        override val io: CoroutineContext
//            get() = testDispatcher
//        override val computation: CoroutineContext
//            get() = testDispatcher
//        override val main: CoroutineContext
//            get() = testDispatcher
//    }
//    private lateinit var viewModel: PokemonListViewModel
//
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testDispatcher)
//        coEvery { getPokemonListItems(0) } answers { PokemonListItems }
//
//        viewModel = PokemonListViewModel(
//            getPokemonListItems,
//            coroutineContextProvider
//        )
//    }
//
//    @Test
//    fun `when view model is created then it should get the pokemons list items with offset 0`() = runTest {
//        assertInitialStatesAreEmitted()
//
//        coVerify(exactly = 1) {
//            getPokemonListItems(0)
//        }
//    }
//
//    @Test
//    fun `when fetch pokemons is called then it should get the pokemons with the next offset based on the previous ones loaded`() = runTest {
//        val newPokemonItems = listOf(PokemonListItems.first().copy(id = 5, name = "Charizard"))
//        coEvery { getPokemonListItems(2) } answers { newPokemonItems }
//
//        assertInitialStatesAreEmitted()
//
//        viewModel.fetchPokemonListItems()
//
//        viewModel.state.test {
//            Assert.assertEquals(
//                PokemonListViewModel.State(
//                    loading = false,
//                    currentSearchQuery = "",
//                    pokemonListItems = PokemonListItems
//                ),
//                awaitItem()
//            )
//            Assert.assertEquals(
//                PokemonListViewModel.State(
//                    loading = true,
//                    currentSearchQuery = "",
//                    pokemonListItems = PokemonListItems
//                ),
//                awaitItem()
//            )
//            Assert.assertEquals(
//                PokemonListViewModel.State(
//                    loading = false,
//                    currentSearchQuery = "",
//                    pokemonListItems = PokemonListItems + newPokemonItems
//                ),
//                awaitItem()
//            )
//        }
//
//        coVerify(exactly = 1) { getPokemonListItems(0) }
//        coVerify(exactly = 1) { getPokemonListItems(2) }
//    }
//
//    private suspend fun assertInitialStatesAreEmitted() {
//        viewModel.state.test {
//            Assert.assertEquals(
//                PokemonListViewModel.State(
//                    loading = true,
//                    currentSearchQuery = "",
//                    pokemonListItems = null
//                ),
//                awaitItem()
//            )
//            Assert.assertEquals(
//                PokemonListViewModel.State(
//                    loading = false,
//                    currentSearchQuery = "",
//                    pokemonListItems = PokemonListItems
//                ),
//                awaitItem()
//            )
//        }
//    }
// }
//
// private val PokemonListItems = listOf(
//    PokemonListItem(
//        id = 1,
//        name = "Venasour",
//        order = 3,
//        image = "url",
//        types = setOf(PokemonListItem.Type(36, "rock", Color(0xff000000)))
//
//    ),
//    PokemonListItem(
//        id = 25,
//        name = "Charmander",
//        order = 5,
//        image = "url2",
//        types = setOf(PokemonListItem.Type(36, "rock", Color(0xff000000)))
//
//    )
// )
