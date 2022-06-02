package com.oscarg798.pokedesk.pokemonlist

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import com.oscarg798.pokedesk.lib.ui.PokeDeskTheme
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel
import com.oscarg798.pokedesk.pokemonlist.ui.PokemonScreen
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class PokemonListScreenTest {

    private val hiltRule = HiltAndroidRule(this)

    private val composeRule = createComposeRule()

    @get:Rule
    val chain = RuleChain.outerRule(hiltRule)
        .around(composeRule)

    @ApplicationContext
    @Inject
    lateinit var context: Context

    private lateinit var viewModel: PokemonListViewModel
    private val navController: NavController = mockk(relaxed = true)
    private val pokemonListPage: PokemonListPage = PokemonListPage(composeRule)

    @Before
    fun setup() {
        hiltRule.inject()
        viewModel = mockk(relaxed = true)
    }

    @Test
    fun Given_a_pokemon_list_When_state_updated_with_it_Then_pokemons_displayed() {
        val stateFlow = MutableStateFlow(PokemonListViewModel.State())
        val eventFlow = MutableSharedFlow<PokemonListViewModel.Event>()

        every { viewModel.state } answers { stateFlow }
        every { viewModel.events } answers { eventFlow }

        stateFlow.value = PokemonListViewModel.State(
            loading = false,
            pokemonListItems = PokemonList
        )

        composeRule.setContent {
            PokeDeskTheme {
                PokemonScreen(viewModel = viewModel, navController = navController)
            }
        }

        pokemonListPage
            .assertPageDisplayed()
            .assertPokemonsDisplayed()

        verify(exactly = 1) {
            viewModel.fetchPokemonListItems()
        }
    }

    @Test
    fun When_a_pokemon_is_clicked_Then_navigate_to_detail() {
        val stateFlow = MutableStateFlow(PokemonListViewModel.State())
        val eventFlow = MutableSharedFlow<PokemonListViewModel.Event>()

        coEvery { viewModel.onItemClicked(1) } coAnswers {
            eventFlow.emit(PokemonListViewModel.Event.NavigateToDetail(1))
        }

        every { viewModel.state } answers { stateFlow }
        every { viewModel.events } answers { eventFlow }

        stateFlow.value = PokemonListViewModel.State(
            loading = false,
            pokemonListItems = PokemonList
        )

        composeRule.setContent {
            PokeDeskTheme {
                PokemonScreen(viewModel = viewModel, navController = navController)
            }
        }

        pokemonListPage
            .assertPageDisplayed()
            .clickPokemon()
            .assertDetailNavigation(navController)

        verify(exactly = 1) {
            viewModel.onItemClicked(1)
        }
    }
}

private val PokemonList = listOf(
    PokemonListItem(
        id = 1,
        name = "Bulbasaur",
        order = 1,
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
        types = setOf(
            PokemonListItem.Type(id = 1, name = "Grass", color = Color.Blue)
        )
    )
)
