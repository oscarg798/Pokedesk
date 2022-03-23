package com.oscarg798.pokedesk.lib.pokemon.repository

import com.google.gson.Gson
import com.oscarg798.pokedesk.lib.PokemonGenerator
import com.oscarg798.pokedesk.lib.pokemon.model.ApiType
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity
import com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity
import com.oscarg798.pokedesk.lib.pokemon.network.PokemonService
import com.oscarg798.pokedesk.lib.pokemon.persistence.PokemonDao
import com.oscarg798.pokedesk.lib.pokemon.persistence.StatsDao
import com.oscarg798.pokedesk.lib.pokemon.persistence.TypeDao
import com.oscarg798.pokedesk.lib.pokemon.utils.IdExtractor
import com.oscarg798.pokedesk.lib.type.TypeService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class PokemonRepositoryTest {

    private val pokemonService: PokemonService = mockk()
    private val typeService: TypeService = mockk()
    private val idExtractor: IdExtractor = IdExtractor()
    private val pokemonDao: PokemonDao = mockk(relaxed = true)
    private val typeDao: TypeDao = mockk(relaxed = true)
    private val statsDao: StatsDao = mockk(relaxed = true)
    private val gson = Gson()

    private lateinit var repository: PokemonRepository

    @Before
    fun setup() {
        repository = PokemonRepository(
            pokemonService = pokemonService,
            typeService = typeService,
            idExtractor = idExtractor,
            pokemonDao = pokemonDao,
            typeDao = typeDao,
            statsDao = statsDao,
            gson = gson
        )
    }

    @Test
    fun `when fetch pokemons invoke then api should be called and response saved`() {
        val apiPokemonListItems = PokemonGenerator.generateAPIPokemonListResponse()
        val apiPokemon = PokemonGenerator.generateAPIPokemon()
        val apiPokemonType = PokemonGenerator.generateAPIPokemonType()
        val pokemonType = with(apiPokemonType) {
            Pokemon.Type(
                id = id,
                name = name,
                damageRelations = Pokemon.Type.DamageRelations(
                    vulnerableTo = damageRelations.vulnerableTo.map {
                        it.toDamageRelationType()
                    }.toSet(),
                    resistantAgainst = damageRelations.resistantAgainst.map {
                        it.toDamageRelationType()
                    }.toSet(),
                    weakTo = damageRelations.weakTo.map {
                        it.toDamageRelationType()
                    }.toSet(),
                    strongAgainst = damageRelations.strongAgainst.map {
                        it.toDamageRelationType()
                    }.toSet(),
                    noAffectedAgainst = damageRelations.noAffectedAgainst.map {
                        it.toDamageRelationType()
                    }.toSet(),
                    noEffectiveTo = damageRelations.noEffectiveTo.map {
                        it.toDamageRelationType()
                    }.toSet()
                )
            )
        }

        coEvery { pokemonService.getPokemonListItems(30, 1) } answers { apiPokemonListItems }
        coEvery { pokemonService.getPokemonDetail(idExtractor.getIdFromUrl(apiPokemonListItems.items.first().url)) } answers { apiPokemon }
        coEvery { typeService.getTypeById(idExtractor.getIdFromUrl(apiPokemon.types.first().detail.url)) } answers { apiPokemonType }

        runTest {
            repository.fetchPokemons(1)
        }

        coVerify {
            pokemonService.getPokemonListItems(30, 1)
            pokemonService.getPokemonDetail(idExtractor.getIdFromUrl(apiPokemonListItems.items.first().url))
            apiPokemon.stats.forEach {
                statsDao.insert(
                    PokemonEntity.Stat(
                        statId = idExtractor.getIdFromUrl(it.statInfo.url),
                        name = it.statInfo.name,
                        value = it.value,
                        pokemonId = apiPokemon.id
                    )
                )
            }

            pokemonDao.insert(
                listOf(
                    PokemonEntity(
                        id = apiPokemon.id,
                        name = apiPokemon.name,
                        order = apiPokemon.order,
                        height = (apiPokemon.height * .1f).toInt(),
                        weight = (apiPokemon.weight * .1f).toInt(),
                        image = apiPokemon.image.getImageUrl()
                    )
                )
            )

            typeDao.insert(
                TypeEntity(
                    id = pokemonType.id,
                    name = pokemonType.name,
                    vulnerableTo = gson.toJson(pokemonType.damageRelations.vulnerableTo),
                    weakTo = gson.toJson(pokemonType.damageRelations.weakTo),
                    strongAgainst = gson.toJson(pokemonType.damageRelations.strongAgainst),
                    noEffectiveTo = gson.toJson(pokemonType.damageRelations.noEffectiveTo),
                    noAffectedAgainst = gson.toJson(pokemonType.damageRelations.noAffectedAgainst),
                    resistantAgainst = gson.toJson(pokemonType.damageRelations.resistantAgainst),
                )
            )
        }
    }

    private fun ApiType.ApiDamageRelation.ApiDamageRelationType.toDamageRelationType() =
        Pokemon.Type.DamageRelations.Type(idExtractor.getIdFromUrl(url), name)
}
