package com.oscarg798.pokedesk.lib

import androidx.compose.ui.graphics.Color
import com.google.gson.Gson
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemon
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListItem
import com.oscarg798.pokedesk.lib.pokemon.model.ApiPokemonListResponse
import com.oscarg798.pokedesk.lib.pokemon.model.ApiType
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import com.oscarg798.pokedesk.lib.pokemon.model.PokemonEntity
import com.oscarg798.pokedesk.lib.pokemon.model.TypeEntity
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import java.util.UUID
import kotlin.random.Random

object PokemonGenerator {

    private val gson = Gson()

    fun generatePokemon(numberOfTypes: Int = 3): Pokemon = Pokemon(
        id = generateRandomValue(Int::class.java),
        name = generateRandomValue(String::class.java),
        order = generateRandomValue(Int::class.java),
        height = generateRandomValue(Int::class.java),
        weight = generateRandomValue(Int::class.java),
        types = generatePokemonTypes(numberOfTypes),
        stats = generateStats(),
        image = generateRandomValue(String::class.java)
    )

    fun generateAPIPokemon(): ApiPokemon = ApiPokemon(
        id = generateRandomValue(Int::class.java),
        name = generateRandomValue(String::class.java),
        order = generateRandomValue(Int::class.java),
        height = generateRandomValue(Int::class.java),
        weight = generateRandomValue(Int::class.java),
        types = generateAPIPokemonTypes(),
        stats = generateAPIPokemonStats(),
        image = ApiPokemon.ApiImages(
            artWork = ApiPokemon.ApiImages.ArtWork(
                ApiPokemon.ApiImages.ArtWork.Detail(generateRandomValue(String::class.java))
            )
        )
    )

    fun generatePokemonEntity(): PokemonEntity = PokemonEntity(
        id = generateRandomValue(Int::class.java),
        name = generateRandomValue(String::class.java),
        order = generateRandomValue(Int::class.java),
        height = generateRandomValue(Int::class.java),
        weight = generateRandomValue(Int::class.java),
        image = generateRandomValue(String::class.java)
    )

    fun generatePokemonEntityStats() = (0..Random.nextInt(3)).map {
        PokemonEntity.Stat(
            statId = generateRandomValue(Int::class.java),
            name = generateRandomValue(String::class.java),
            value = generateRandomValue(Int::class.java),
            pokemonId = generateRandomValue(Int::class.java)
        )
    }

    fun generatePokemonTypeEntity() = TypeEntity(
        id = generateRandomValue(Int::class.java),
        name = generateRandomValue(String::class.java),
        vulnerableTo = gson.toJson(generatePokemonTypeDamageRelationshipType()),
        resistantAgainst = gson.toJson(generatePokemonTypeDamageRelationshipType()),
        weakTo = gson.toJson(generatePokemonTypeDamageRelationshipType()),
        strongAgainst = gson.toJson(generatePokemonTypeDamageRelationshipType()),
        noEffectiveTo = gson.toJson(generatePokemonTypeDamageRelationshipType()),
        noAffectedAgainst = gson.toJson(generatePokemonTypeDamageRelationshipType())
    )

    fun generateAPIPokemonType() = ApiType(
        id = generateRandomValue(Int::class.java),
        name = generateRandomValue(String::class.java),
        damageRelations = ApiType.ApiDamageRelation(
            vulnerableTo = generateApiDamageRelationType(),
            resistantAgainst = generateApiDamageRelationType(),
            weakTo = generateApiDamageRelationType(),
            strongAgainst = generateApiDamageRelationType(),
            noEffectiveTo = generateApiDamageRelationType(),
            noAffectedAgainst = generateApiDamageRelationType()
        )
    )

    fun generateApiDamageRelationType() = (0..Random.nextInt(3)).map {
        ApiType.ApiDamageRelation.ApiDamageRelationType(
            url = generateRandomUrl(),
            name = generateRandomValue(String::class.java)
        )
    }

    fun generateAPIPokemonListResponse() = ApiPokemonListResponse(
        count = generateRandomValue(Int::class.java),
        items = listOf(
            ApiPokemonListItem(
                name = generateRandomValue(String::class.java),
                url = generateRandomUrl()
            )
        )
    )

    fun generatePokemonListItems() = (0..Random.nextInt(3)).map {
        PokemonListItem(
            id = generateRandomValue(Int::class.java),
            generateRandomValue(String::class.java),
            generateRandomValue(Int::class.java),
            generateRandomValue(String::class.java),
            types = (0..Random.nextInt(3)).map {
                PokemonListItem.Type(
                    generateRandomValue(Int::class.java),
                    generateRandomValue(String::class.java),
                    if (it % 2 == 0) Color.Blue else Color.Gray
                )
            }.toSet()
        )
    }

    private fun generateRandomUrl() = "http://url/url/${Random.nextInt(3)}/"

    private fun generateAPIPokemonTypes() = listOf(
        ApiPokemon.APIType(
            ApiPokemon.APIType.Detail(
                url = generateRandomUrl(),
                name = generateRandomValue(String::class.java)
            )
        )
    )

    private fun generateAPIPokemonStats() = (0..Random.nextInt(3)).map {
        ApiPokemon.ApiStat(
            value = generateRandomValue(Int::class.java),
            statInfo = ApiPokemon.ApiStat.ApiStatInfo(
                url = generateRandomUrl(),
                name = generateRandomValue(String::class.java)
            )
        )
    }

    private fun generateStats() = (0..Random.nextInt(3)).map {
        Pokemon.Stat(
            id = generateRandomValue(Int::class.java),
            name = generateRandomValue(String::class.java),
            value = generateRandomValue(Int::class.java)
        )
    }.toSet()

    private fun generatePokemonTypes(examples: Int = 3) = (0..Random.nextInt(examples)).map {
        Pokemon.Type(
            generateRandomValue(Int::class.java),
            generateRandomValue(String::class.java),
            damageRelations = Pokemon.Type.DamageRelations(
                vulnerableTo = generatePokemonTypeDamageRelationshipType(),
                resistantAgainst = generatePokemonTypeDamageRelationshipType(),
                weakTo = generatePokemonTypeDamageRelationshipType(),
                strongAgainst = generatePokemonTypeDamageRelationshipType(),
                noAffectedAgainst = generatePokemonTypeDamageRelationshipType(),
                noEffectiveTo = generatePokemonTypeDamageRelationshipType()
            )
        )
    }.toSet()

    private fun generatePokemonTypeDamageRelationshipType() = (0..Random.nextInt(3)).map {
        Pokemon.Type.DamageRelations.Type(
            id = generateRandomValue(Int::class.java),
            name = generateRandomValue(String::class.java)
        )
    }.toSet()
}

fun <T> generateRandomValue(type: Class<*>): T {

    return when (type) {
        String::class.java -> UUID.randomUUID().toString()
        Int::class.java -> Random.nextInt()
        Double::class.java -> Random.nextDouble()
        Float::class.java -> Random.nextFloat()
        else -> throw IllegalStateException("Type $type not found")
    } as T
}
