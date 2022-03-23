package com.oscarg798.pokedesk.pokemonlist

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.performClick
import androidx.navigation.NavController
import io.mockk.verify

class PokemonListPage(private val composeTestRule: ComposeTestRule) {

    fun assertPageDisplayed(): PokemonListPage {
        composeTestRule.waitForIdle()
        composeTestRule.onNode(hasText("Search")).assertIsDisplayed()
        return this
    }

    fun assertPokemonsDisplayed(): PokemonListPage {
        composeTestRule.onNode(hasText("Search")).assertIsDisplayed()
        composeTestRule.onNode(hasText("Bulbasaur")).assertIsDisplayed()
        composeTestRule.onNode(hasText("#1")).assertIsDisplayed()
        composeTestRule.onNode(hasText("Grass")).assertIsDisplayed()
        return this
    }

    fun clickPokemon(): PokemonListPage {
        composeTestRule.onNode(hasText("Bulbasaur"))
            .performClick()
        composeTestRule.waitForIdle()
        composeTestRule.mainClock.advanceTimeBy(3_000)
        return this
    }

    fun assertDetailNavigation(navController: NavController): PokemonListPage {
        verify(exactly = 1) {
            navController.navigate(
                deepLink = match {
                    it.toString() == "https://pokedesk//pokemonDetail/1"
                },
                navOptions = any()
            )
        }

        return this
    }
}
