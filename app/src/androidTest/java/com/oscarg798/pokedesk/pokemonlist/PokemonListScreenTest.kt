package com.oscarg798.pokedesk.pokemonlist

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import com.oscarg798.pokedesk.LocalNavControllerProvider
import com.oscarg798.pokedesk.lib.ui.PokeDeskTheme
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.ui.PokemonListViewModel
import com.oscarg798.pokedesk.pokemonlist.ui.PokemonScreen
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

class PokemonListScreenTest {

    @get:Rule
    val composeRule = createComposeRule()

    private val navController: NavController = mockk(relaxed = true)
    private val pokemonListPage: PokemonListPage = PokemonListPage(composeRule)

    @Test
    fun Given_a_pokemon_list_When_state_updated_with_it_Then_pokemons_displayed() {
        composeRule.setContent {

            PokeDeskTheme {
                CompositionLocalProvider(LocalNavControllerProvider provides navController) {
                    PokemonScreen(
                        state = PokemonListViewModel.State(
                            loading = false,
                            pokemonListItems = PokemonList
                        ),
                        onItemClicked = { },
                        onBottomReached = { }
                    )
                }
            }
        }

        pokemonListPage
            .assertPageDisplayed()
            .assertPokemonsDisplayed()
    }

    @Test
    fun When_a_pokemon_is_clicked_Then_navigate_to_detail() {
        composeRule.setContent {
            val events = remember { mutableStateOf<PokemonListViewModel.Event?>(null) }

            PokeDeskTheme {
                CompositionLocalProvider(LocalNavControllerProvider provides navController) {
                    PokemonScreen(
                        state = PokemonListViewModel.State(
                            loading = false,
                            pokemonListItems = PokemonList
                        ),
                        onItemClicked = {
                            events.value = PokemonListViewModel.Event.NavigateToDetail(it)
                        },
                        onBottomReached = { },
                        events = events.value
                    )
                }
            }
        }

        pokemonListPage
            .assertPageDisplayed()
            .clickPokemon()
            .assertDetailNavigation(navController)
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
