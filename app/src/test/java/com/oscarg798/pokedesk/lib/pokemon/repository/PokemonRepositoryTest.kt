package com.oscarg798.pokedesk.lib.pokemon.repository

import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListItem
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListResponse
import com.oscarg798.pokedesk.lib.pokemon.model.ApiType
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import com.oscarg798.pokedesk.lib.pokemon.network.PokemonService
import com.oscarg798.pokedesk.lib.pokemon.utils.IdExtractor
import com.oscarg798.pokedesk.lib.type.TypeService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonRepositoryTest {

    private val pokemonService: PokemonService = mockk()
    private val typeService: TypeService = mockk()
    private val idExtractor: IdExtractor = IdExtractor()

    private lateinit var repository: PokemonRepository

    @Before
    fun setup() {
        repository = PokemonRepository(
            pokemonService = pokemonService,
            typeService = typeService,
            idExtractor = idExtractor
        )
    }

    @Test
    fun `when get pokemons invoke then it should return the pokemons`() {
        coEvery { pokemonService.getPokemonListItems(20, 0) } answers { APiPokemonListResultsMock }
        coEvery { pokemonService.getPokemonDetail(3) } answers { ApiPokemonMock }
        coEvery { typeService.getTypeById(6) } answers { ApiTypeMock }

        runTest {
            val result = repository.getPokemons()
            Assert.assertEquals(listOf(PokemonMock), result)
        }

        coVerify {
            pokemonService.getPokemonDetail(3)
            pokemonService.getPokemonListItems(20, 0)
        }
    }
}

private val APiPokemonListResultsMock = ApiPokemonListResponse(
    count = 134,
    items = listOf(ApiPokemonListItem("Charmander", "f/g/h/3/"))
)

private val ApiPokemonMock = ApiPokemon(
    id = 1,
    name = "Venasour",
    order = 3,
    height = 4,
    weight = 5,
    types = listOf(
        ApiPokemon.APIType(detail = ApiPokemon.APIType.Detail(url = "a/b/6/", name = "poison"))
    ),
    stats = listOf(
        ApiPokemon.ApiStat(
            value = 34,
            statInfo = ApiPokemon.ApiStat.ApiStatInfo("url/2/4/", "attack")
        )
    ),
    image = ApiPokemon.ApiImages(ApiPokemon.ApiImages.ArtWork(ApiPokemon.ApiImages.ArtWork.Detail("url")))
)

private val ApiTypeMock = ApiType(
    36, "rock",
    ApiType.ApiDamageRelation(
        vulnerableTo = listOf(
            ApiType.ApiDamageRelation.ApiDamageRelationType(
                "c/g/h/3/",
                "poison"
            )
        ),
        resistantAgainst = listOf(
            ApiType.ApiDamageRelation.ApiDamageRelationType(
                "u/h/585/",
                "rock"
            )
        ),
        noEffectiveTo = listOf(
            ApiType.ApiDamageRelation.ApiDamageRelationType("cvb/sd/w/99/", "psyco"),
            ApiType.ApiDamageRelation.ApiDamageRelationType("qrr/x/ddh/88/", "psycoRockera")
        ),
        weakTo = listOf(),
        strongAgainst = listOf(
            ApiType.ApiDamageRelation.ApiDamageRelationType(
                "u/h/154/",
                "poision"
            )
        ),
        noAffectedAgainst = listOf(
            ApiType.ApiDamageRelation.ApiDamageRelationType(
                "te/hsad/1/",
                "flying"
            )
        )
    )
)

private val PokemonMock = Pokemon(
    id = 1,
    name = "Venasour",
    order = 3,
    height = 4,
    weight = 5,
    types = setOf(
        Pokemon.Type(
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
    ),
    stats = setOf(Pokemon.Stat(4, "attack", 34)),
    image = "url"
)
