package com.oscarg798.pokedesk.pokemondetail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.ComposeTestRule
import com.oscarg798.pokedesk.detail.model.PokemonDetail

class PokemonDetailPage(private val composeTestRule: ComposeTestRule) {

    fun assertPokemonDetailDisplayed(pokemonDetail: PokemonDetail) {
        composeTestRule.waitForIdle()
        composeTestRule.onNode(hasText(pokemonDetail.name)).assertIsDisplayed()
        composeTestRule.onNode(hasText("Height:")).assertIsDisplayed()
        composeTestRule.onNode(hasText("${pokemonDetail.height} m")).assertIsDisplayed()
        composeTestRule.onNode(hasText("Weight:")).assertIsDisplayed()
        composeTestRule.onNode(hasText("${pokemonDetail.weight} kg")).assertIsDisplayed()
        pokemonDetail.types.forEach {
            composeTestRule.onNode(hasText(it.name, ignoreCase = true)).assertIsDisplayed()
        }
        pokemonDetail.stats.forEach {
            composeTestRule.onNode(hasText(it.name, ignoreCase = true)).assertIsDisplayed()
        }
    }
}
