package com.oscarg798.pokedesk.lib.pokemon.repository

import app.cash.turbine.test
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.oscarg798.pokedesk.lib.PokemonGenerator
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon
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
import io.mockk.Called
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
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
    fun `when getPokemons called then it should return a flow with what is in the database`() =
        runTest {
            val pokemonEntity = PokemonGenerator.generatePokemonEntity()
            val pokemonStatesEntities = PokemonGenerator.generatePokemonEntityStats()
            val pokemonTypes = PokemonGenerator.generatePokemonTypeEntity()

            coEvery { pokemonDao.getAll() } answers { flowOf(listOf(pokemonEntity)) }
            coEvery { typeDao.getTypeIdFromPokemonId(pokemonEntity.id) } answers {
                listOf(
                    pokemonTypes.id
                )
            }
            coEvery { typeDao.getById(pokemonTypes.id) } answers { pokemonTypes }
            coEvery { statsDao.getByPokemonId(pokemonEntity.id) } answers { pokemonStatesEntities }

            val pokemonStatsType =
                object : TypeToken<Set<Pokemon.Type.DamageRelations.Type>>() {}.type
            repository.getPokemons().test {
                Assert.assertEquals(
                    listOf(
                        Pokemon(
                            id = pokemonEntity.id,
                            name = pokemonEntity.name,
                            order = pokemonEntity.order,
                            height = pokemonEntity.height,
                            weight = pokemonEntity.weight,
                            types = setOf(
                                Pokemon.Type(
                                    pokemonTypes.id,
                                    pokemonTypes.name,
                                    Pokemon.Type.DamageRelations(
                                        vulnerableTo = gson.fromJson(
                                            pokemonTypes.vulnerableTo,
                                            pokemonStatsType
                                        ),
                                        resistantAgainst = gson.fromJson(
                                            pokemonTypes.resistantAgainst,
                                            pokemonStatsType
                                        ),
                                        weakTo = gson.fromJson(
                                            pokemonTypes.weakTo,
                                            pokemonStatsType
                                        ),
                                        strongAgainst = gson.fromJson(
                                            pokemonTypes.strongAgainst,
                                            pokemonStatsType
                                        ),
                                        noEffectiveTo = gson.fromJson(
                                            pokemonTypes.noEffectiveTo,
                                            pokemonStatsType
                                        ),
                                        noAffectedAgainst = gson.fromJson(
                                            pokemonTypes.noAffectedAgainst,
                                            pokemonStatsType
                                        )
                                    )
                                )
                            ),
                            stats = pokemonStatesEntities.map {
                                Pokemon.Stat(it.statId, it.name, it.value)
                            }.toSet(),
                            image = pokemonEntity.image
                        )
                    ),
                    awaitItem()
                )
                awaitComplete()
            }

            coVerify(exactly = 1) {
                pokemonDao.getAll()
                typeDao.getTypeIdFromPokemonId(pokemonEntity.id)
                typeDao.getById(pokemonTypes.id)
                statsDao.getByPokemonId(pokemonEntity.id)
            }

            coVerify {
                pokemonService wasNot Called
            }
        }

    @Test
    fun `given a pokemonId when getPokemonDetails is called then it should return the pokemon matching that id`() =
        runTest {
            val apiPokemon = PokemonGenerator.generateAPIPokemon()
            val apiType = PokemonGenerator.generateAPIPokemonType()
            val pokemonEntity = apiPokemon.toPokemonEntity()
            val pokemonStats = apiPokemon.stats.toStats()
            val pokemonType = apiType.toPokemonType()

            coEvery { pokemonDao.getById(apiPokemon.id) } answers { pokemonEntity }
            coEvery { typeDao.getTypeIdFromPokemonId(pokemonEntity.id) } answers { listOf(apiType.id) }
            coEvery { typeDao.getById(apiType.id) } answers { pokemonType.toTypeEntity() }
            coEvery { statsDao.getByPokemonId(apiPokemon.id) } answers {
                pokemonStats.map {
                    PokemonEntity.Stat(
                        statId = it.id,
                        name = it.name,
                        value = it.value,
                        pokemonId = apiPokemon.id
                    )
                }
            }
            coEvery { typeService.getTypeById(idExtractor.getIdFromUrl(apiPokemon.types.first().detail.url)) } answers { apiType }
            coEvery { pokemonService.getPokemonDetail(apiPokemon.id) } answers { apiPokemon }

            val result = repository.getPokemonDetail(apiPokemon.id)

            Assert.assertEquals(apiPokemon.toPokemon(apiType), result)

            coVerify(exactly = 1) {
                pokemonDao.getById(apiPokemon.id)
                typeDao.getTypeIdFromPokemonId(pokemonEntity.id)
                typeDao.getById(apiType.id)
                statsDao.getByPokemonId(apiPokemon.id)
                typeService.getTypeById(idExtractor.getIdFromUrl(apiPokemon.types.first().detail.url))
                pokemonService.getPokemonDetail(apiPokemon.id)
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

                pokemonDao.insert(apiPokemon.toPokemonEntity())
                typeDao.insert(pokemonType.toTypeEntity())
            }
        }

    @Test
    fun `when fetch pokemons invoke then api should be called and response saved`() {
        val apiPokemonListItems = PokemonGenerator.generateAPIPokemonListResponse()
        val apiPokemon = PokemonGenerator.generateAPIPokemon()
        val apiPokemonType = PokemonGenerator.generateAPIPokemonType()
        val pokemonType = apiPokemonType.toPokemonType()

        coEvery { pokemonService.getPokemonListItems(30, 1) } answers { apiPokemonListItems }
        coEvery { pokemonService.getPokemonDetail(idExtractor.getIdFromUrl(apiPokemonListItems.items.first().url)) } answers { apiPokemon }
        coEvery { typeService.getTypeById(idExtractor.getIdFromUrl(apiPokemon.types.first().detail.url)) } answers { apiPokemonType }

        runTest {
            repository.fetchPokemons(1)
        }

        coVerify(exactly = 1) {
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
                    apiPokemon.toPokemonEntity()
                )
            )

            typeDao.insert(pokemonType.toTypeEntity())
        }
    }

    private fun ApiPokemon.toPokemonEntity() = PokemonEntity(
        id = id,
        name = name,
        order = order,
        height = (height * .1f).toInt(),
        weight = (weight * .1f).toInt(),
        image = image.getImageUrl()
    )

    private fun ApiPokemon.toPokemon(apiType: ApiType) = Pokemon(
        id = id,
        name = name,
        order = order,
        height = (height * .1f).toInt(),
        weight = (weight * .1f).toInt(),
        stats = stats.toStats(),
        image = image.getImageUrl(),
        types = types.map {
            apiType.toPokemonType()
        }.toSet()
    )

    private fun List<ApiPokemon.ApiStat>.toStats() = map { it.toStat() }.toSet()

    private fun Pokemon.Type.toTypeEntity() = TypeEntity(
        id = id,
        name = name,
        vulnerableTo = gson.toJson(damageRelations.vulnerableTo),
        weakTo = gson.toJson(damageRelations.weakTo),
        strongAgainst = gson.toJson(damageRelations.strongAgainst),
        noEffectiveTo = gson.toJson(damageRelations.noEffectiveTo),
        noAffectedAgainst = gson.toJson(damageRelations.noAffectedAgainst),
        resistantAgainst = gson.toJson(damageRelations.resistantAgainst),
    )

    private fun ApiType.toPokemonType() = Pokemon.Type(
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

    private fun ApiType.ApiDamageRelation.ApiDamageRelationType.toDamageRelationType() =
        Pokemon.Type.DamageRelations.Type(idExtractor.getIdFromUrl(url), name)
}
