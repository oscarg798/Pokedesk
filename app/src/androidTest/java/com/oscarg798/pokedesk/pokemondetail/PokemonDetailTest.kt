package com.oscarg798.pokedesk.pokemondetail

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavController
import com.oscarg798.pokedesk.LocalNavControllerProvider
import com.oscarg798.pokedesk.detail.model.PokemonDetail
import com.oscarg798.pokedesk.detail.ui.PokemonDetailScreen
import com.oscarg798.pokedesk.detail.ui.PokemonDetailViewModel
import com.oscarg798.pokedesk.lib.ui.PokeDeskTheme
import io.mockk.mockk
import java.util.UUID
import kotlin.random.Random
import org.junit.Rule
import org.junit.Test

class PokemonDetailTest {

    @get:Rule
    val composeRule = createComposeRule()

    private val navController: NavController = mockk(relaxed = true)
    private val pokemonDetailPage: PokemonDetailPage = PokemonDetailPage(composeRule)

    @Test
    fun Given_a_pokemon_when_screen_shown_Then_detail_shown_properly() {
        val pokemonDetail = Pokemon.copy(stats = generateStats())

        composeRule.setContent {
            val scrollState = rememberScrollState(Int.MAX_VALUE)

            PokeDeskTheme {
                CompositionLocalProvider(LocalNavControllerProvider provides navController) {
                    PokemonDetailScreen(
                        state = PokemonDetailViewModel.State(pokemon = pokemonDetail),
                        modifier = Modifier.verticalScroll(scrollState)
                    )
                }
            }
        }

        pokemonDetailPage.assertPokemonDetailDisplayed(pokemonDetail)
    }

    private fun generateStats() = (0 until 6).map {
        PokemonDetail.Stat(
            com.oscarg798.pokedesk.lib.pokemon.model.Pokemon.Stat(
                id = it,
                name = UUID.randomUUID().toString().substring(0, 5),
                value = Random.nextInt(100)
            )
        )
    }.toSet()
}

val Pokemon = PokemonDetail(
    id = 1,
    name = "Charmander",
    order = 4,
    height = 13,
    weight = 6,
    types = setOf(
        PokemonDetail.Type(
            id = 1,
            name = "Fire",
            color = Color.Red,
            damageRelations = com.oscarg798.pokedesk.lib.pokemon.model.Pokemon.Type.DamageRelations(
                vulnerableTo = setOf(),
                resistantAgainst = setOf(),
                weakTo = setOf(),
                strongAgainst = setOf(),
                noEffectiveTo = setOf(),
                noAffectedAgainst = setOf()
            )
        )
    ),
    stats = setOf(),
    image = ""
)
