package com.oscarg798.pokedesk.lib.pokemonlist.usecase

import androidx.compose.ui.graphics.Color
import app.cash.turbine.test
import com.oscarg798.pokedesk.lib.PokemonGenerator
import com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository
import com.oscarg798.pokedesk.lib.type.TypeRepository
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetPokemonsListItemsTest {

    private val pokemonRepository: PokemonRepository = mockk()
    private val typeRepository: TypeRepository = mockk()
    private lateinit var usecase: GetPokemonListItems

    @Before
    fun before() {
        usecase = GetPokemonListItems(
            pokemonRepository = pokemonRepository,
            typeRepository = typeRepository
        )
    }

    @Test
    fun `when invoke then it should return a list based on the pokemons returned by the repo sorted by its id`() =
        runTest {
            val pokemons = listOf(
                PokemonGenerator.generatePokemon(1),
                PokemonGenerator.generatePokemon(1)
            ).sortedBy { it.id }

            coEvery { pokemonRepository.getPokemons() } answers { flowOf(pokemons) }
            every { typeRepository.getColorFromType(pokemons.first().types.first()) } answers { 0xff000000 }
            every { typeRepository.getColorFromType(pokemons.last().types.first()) } answers { 0xffffffff }

            usecase().test {
                Assert.assertEquals(
                    listOf(
                        PokemonListItem(
                            id = pokemons.first().id,
                            name = pokemons.first().name,
                            order = pokemons.first().order,
                            image = pokemons.first().image,
                            types = setOf(
                                PokemonListItem.Type(pokemons.first().types.first().id, pokemons.first().types.first().name, Color(0xff000000))
                            )

                        ),
                        PokemonListItem(
                            id = pokemons.last().id,
                            name = pokemons.last().name,
                            order = pokemons.last().order,
                            image = pokemons.last().image,
                            types = setOf(
                                PokemonListItem.Type(pokemons.last().types.last().id, pokemons.last().types.first().name, Color(0xffffffff))
                            )

                        )
                    ),
                    awaitItem()
                )
                awaitComplete()
            }

            coVerify(exactly = 1) {
                pokemonRepository.getPokemons()
                typeRepository.getColorFromType(pokemons.first().types.first())
                typeRepository.getColorFromType(pokemons.last().types.first())
            }
        }
}
