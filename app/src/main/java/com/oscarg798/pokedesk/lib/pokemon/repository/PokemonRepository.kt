package com.oscarg798.pokedesk.lib.pokemon.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListItem
import com.oscarg798.pokedesk.lib.pokemon.model.ApiType
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonTypeRef
import com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity
import com.oscarg798.pokedesk.lib.pokemon.network.PokemonService
import com.oscarg798.pokedesk.lib.pokemon.persistence.PokemonDao
import com.oscarg798.pokedesk.lib.pokemon.persistence.StatsDao
import com.oscarg798.pokedesk.lib.pokemon.persistence.TypeDao
import com.oscarg798.pokedesk.lib.pokemon.utils.IdExtractor
import com.oscarg798.pokedesk.lib.type.TypeService
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@Singleton
class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val typeService: TypeService,
    private val idExtractor: IdExtractor,
    private val pokemonDao: PokemonDao,
    private val typeDao: TypeDao,
    private val statsDao: StatsDao,
    private val gson: Gson
) {

    fun getPokemons(): Flow<List<Pokemon>> {
        return pokemonDao.getAll().map { pokemonsEntities ->
            pokemonsEntities.map { pokemonEntity ->
                getPokemonEntitiyWithTypesAndStats(pokemonEntity)
            }
        }.map { pokemonEntityWithTypeAndStat ->
            pokemonEntityWithTypeAndStat.map {
                it.toPokemon()
            }
        }
    }

    private fun PokemonEntityWithTypesAndStats.toPokemon() = Pokemon(
        id = pokemonEntity.id,
        name = pokemonEntity.name,
        order = pokemonEntity.order,
        height = pokemonEntity.height,
        weight = pokemonEntity.weight,
        stats = stats.map
        { statEntity ->
            Pokemon.Stat(statEntity.statId, statEntity.name, statEntity.value)
        }.toSet(),
        image = pokemonEntity.image,
        types = types.map
        { typeEntity ->
            typeEntity.toType()
        }.toSet()
    )

    private suspend fun getPokemonEntitiyWithTypesAndStats(pokemonEntity: PokemonEntity): PokemonEntityWithTypesAndStats =
        coroutineScope {
            ensureActive()
            val typeIds = typeDao.getTypeIdFromPokemonId(pokemonEntity.id)
            val types = async {
                typeIds.map { id ->
                    async {
                        typeDao.getById(id)
                    }
                }.awaitAll()
            }

            val stats = async {
                statsDao.getByPokemonId(pokemonEntity.id)
            }

            PokemonEntityWithTypesAndStats(
                pokemonEntity = pokemonEntity,
                types = types.await().toSet(),
                stats = stats.await().toSet()
            )
        }

    suspend fun fetchPokemons(offSet: Int) = coroutineScope {
        val items = pokemonService.getPokemonListItems(Limit, offSet).items

        val pokemons = items.map {
            getPokemonDetail(it)
        }.awaitAll()

        val pokemonEntities = pokemons.map { pokemon ->
            pokemon.toPokemonEntitySavingStatsAndTypes()
        }

        pokemonDao.insert(pokemonEntities)
    }

    private suspend fun getPokemonDetail(
        apiPokemonListItem: ApiPokemonListItem
    ) = coroutineScope {
        async() {
            ensureActive()
            fetchPokemonDetail(idExtractor.getIdFromUrl(apiPokemonListItem.url))
        }
    }

    private suspend fun fetchPokemonDetail(id: Int): Pokemon {
        return pokemonService.getPokemonDetail(id).toPokemon()
    }

    suspend fun getPokemonDetail(id: Int): Pokemon = coroutineScope {
        launch {
            ensureActive()
            val pokemonEntity = fetchPokemonDetail(id).toPokemonEntitySavingStatsAndTypes()
            pokemonDao.insert(pokemonEntity)
        }

        getPokemonEntitiyWithTypesAndStats(pokemonDao.getById(id)).toPokemon()
    }

    private suspend fun ApiPokemon.toPokemon(): Pokemon = Pokemon(
        id = id,
        name = name,
        order = order,
        height = height,
        weight = weight,
        stats = stats.map { it.toStat() }.toSet(),
        image = image.getImageUrl(),
        types = types.map {
            getType(it).toType()
        }.toSet()
    )

    private suspend fun getType(type: ApiPokemon.APIType): ApiType {
        return typeService.getTypeById(idExtractor.getIdFromUrl(type.detail.url))
    }

    private fun TypeEntity.toType(): Pokemon.Type {
        val damageRelationsType =
            object : TypeToken<List<Pokemon.Type.DamageRelations.Type>>() {}.type

        return Pokemon.Type(
            id = id,
            name = name,
            damageRelations = Pokemon.Type.DamageRelations(
                vulnerableTo = (
                    gson.fromJson(
                        vulnerableTo,
                        damageRelationsType
                    ) as List<Pokemon.Type.DamageRelations.Type>
                    ).toSet(),
                resistantAgainst = (
                    gson.fromJson(
                        resistantAgainst,
                        damageRelationsType
                    ) as List<Pokemon.Type.DamageRelations.Type>
                    ).toSet(),
                weakTo = (
                    gson.fromJson(
                        weakTo,
                        damageRelationsType
                    ) as List<Pokemon.Type.DamageRelations.Type>
                    ).toSet(),
                strongAgainst = (
                    gson.fromJson(
                        strongAgainst,
                        damageRelationsType
                    ) as List<Pokemon.Type.DamageRelations.Type>
                    ).toSet(),
                noAffectedAgainst = (
                    gson.fromJson(
                        noAffectedAgainst,
                        damageRelationsType
                    ) as List<Pokemon.Type.DamageRelations.Type>
                    ).toSet(),
                noEffectiveTo = (
                    gson.fromJson(
                        noEffectiveTo,
                        damageRelationsType
                    ) as List<Pokemon.Type.DamageRelations.Type>
                    ).toSet()
            )
        )
    }

    private fun ApiType.toType(): Pokemon.Type = Pokemon.Type(
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

    private suspend fun Pokemon.toPokemonEntitySavingStatsAndTypes() = coroutineScope {
        ensureActive()
        val statsJob = async {
            stats.map { stat ->
                async {
                    ensureActive()
                    statsDao.insert(
                        PokemonEntity.Stat(
                            statId = stat.id,
                            name = stat.name,
                            value = stat.value,
                            pokemonId = id
                        )
                    )
                }
            }.awaitAll()
        }

        val typesJob = async {
            types.map {
                async {
                    ensureActive()
                    typeDao.insert(
                        TypeEntity(
                            id = it.id,
                            name = it.name,
                            vulnerableTo = gson.toJson(it.damageRelations.vulnerableTo),
                            weakTo = gson.toJson(it.damageRelations.weakTo),
                            strongAgainst = gson.toJson(it.damageRelations.strongAgainst),
                            noEffectiveTo = gson.toJson(it.damageRelations.noEffectiveTo),
                            noAffectedAgainst = gson.toJson(it.damageRelations.noAffectedAgainst),
                            resistantAgainst = gson.toJson(it.damageRelations.resistantAgainst),
                        )
                    )

                    typeDao.insert(PokemonTypeRef(id, it.id))
                }
            }.awaitAll()
        }

        Pair(typesJob.await(), statsJob.await())

        PokemonEntity(
            id = id,
            name = name,
            order = order,
            height = height,
            weight = weight,
            image = image
        )
    }

    private fun ApiType.ApiDamageRelation.ApiDamageRelationType.toDamageRelationType() =
        Pokemon.Type.DamageRelations.Type(idExtractor.getIdFromUrl(url), name)

    private data class PokemonEntityWithTypesAndStats(
        val pokemonEntity: PokemonEntity,
        val types: Set<TypeEntity>,
        val stats: Set<PokemonEntity.Stat>
    )
}

private const val Limit = 30
