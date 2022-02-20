package com.oscarg798.pokedesk.lib.pokemonlist.usecase

import androidx.compose.ui.graphics.Color
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository
import com.oscarg798.pokedesk.lib.type.TypeRepository
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
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
            coEvery { pokemonRepository.getPokemons(0) } answers {
                listOf(
                    PokemonMock.copy(id = 25, name = "Charmander", image = "url2", order = 5),
                    PokemonMock
                )
            }
            every { typeRepository.getColorFromType(PokemonTypeMock) } answers { 0xff000000 }

            Assert.assertEquals(
                listOf(
                    PokemonListItem(
                        id = 1,
                        name = "Venasour",
                        order = 3,
                        image = "url",
                        types = setOf(PokemonListItem.Type(36, "rock", Color(0xff000000)))

                    ),
                    PokemonListItem(
                        id = 25,
                        name = "Charmander",
                        order = 5,
                        image = "url2",
                        types = setOf(PokemonListItem.Type(36, "rock", Color(0xff000000)))

                    )
                ),
                usecase(0)
            )

            coVerify(exactly = 1) { pokemonRepository.getPokemons(0) }
        }
}

private val PokemonTypeMock = Pokemon.Type(
    36, "rock",
    Pokemon.Type.DamageRelations(
        vulnerableTo = setOf(Pokemon.Type.DamageRelations.Type(3, "poison")),
        strongAgainst = setOf(Pokemon.Type.DamageRelations.Type(154, "poision")),
        noEffectiveTo = setOf(
            Pokemon.Type.DamageRelations.Type(99, "psyco"),
            Pokemon.Type.DamageRelations.Type(88, "psycoRockera")
        ),
        resistantAgainst = setOf(Pokemon.Type.DamageRelations.Type(585, "rock")),
        noAffectedAgainst = setOf(Pokemon.Type.DamageRelations.Type(1, "flying")),
        weakTo = setOf()
    )
)

private val PokemonMock = Pokemon(
    id = 1,
    name = "Venasour",
    order = 3,
    height = 4,
    weight = 5,
    types = setOf(PokemonTypeMock),
    stats = setOf(Pokemon.Stat(4, "attack", 34)),
    image = "url"
)
