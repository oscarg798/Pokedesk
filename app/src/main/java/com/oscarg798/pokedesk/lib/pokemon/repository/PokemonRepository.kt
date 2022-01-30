package com.oscarg798.pokedesk.lib.pokemon.repository

import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon
import com.oscarg798.pokedesk.lib.pokemon.model.ApiType
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import com.oscarg798.pokedesk.lib.pokemon.network.PokemonService
import com.oscarg798.pokedesk.lib.pokemon.utils.IdExtractor
import com.oscarg798.pokedesk.lib.type.TypeService
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

@Singleton
class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val typeService: TypeService,
    private val idExtractor: IdExtractor
) {

    suspend fun getPokemons(): List<Pokemon> {

        val items = pokemonService.getPokemonListItems(20, 0).items

        return items.map {
            pokemonService.getPokemonDetail(idExtractor.getIdFromUrl(it.url))
        }.map {
            it.toPokemon()
        }.awaitAll()
    }

    private suspend fun ApiPokemon.toPokemon(): Deferred<Pokemon> = coroutineScope {
        async {

            Pokemon(
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
        }
    }

    private suspend fun getType(type: ApiPokemon.APIType): ApiType {
        return typeService.getTypeById(idExtractor.getIdFromUrl(type.detail.url))
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

    private fun ApiType.ApiDamageRelation.ApiDamageRelationType.toDamageRelationType() =
        Pokemon.Type.DamageRelations.Type(idExtractor.getIdFromUrl(url), name)
}
