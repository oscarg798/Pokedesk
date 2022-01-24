package com.oscarg798.pokedesk.lib.pokemon

import android.util.Log
import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(private val pokemonService: PokemonService) {

    suspend fun getPokemons(): List<Pokemon> {

        val items = pokemonService.getPokemonListItems(5, 0).items

        items.map {
            pokemonService.getPokemonDetail(it.url.split("/").takeLast(2).first())
        }.forEach {
            Log.i("POKEMON", it.toString())
        }
        return Pokemons
    }

}

private val IdToken = "/"
private val Pokemons = listOf(
    Pokemon(
        id = 1,
        name = "dratini",
        order = 227,
        height = 18,
        weight = 33,
        types = setOf(
            Pokemon.Type(
                1, "normal", Pokemon.Type.DamageRelations(
                    vulnerableTo = setOf(),
                    resistantAgainst = setOf(),
                    weakTo = setOf(),
                    strongAgainst = setOf(),
                    noEffectiveTo = setOf(),
                    noAffectedAgainst = setOf()
                )
            ),
            Pokemon.Type(
                6, "ground", Pokemon.Type.DamageRelations(
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
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/147.png"
    ),
    Pokemon(
        id = 2,
        name = "arbok",
        order = 33,
        height = 35,
        weight = 24,
        types = setOf(
            Pokemon.Type(
                13, "electric", Pokemon.Type.DamageRelations(
                    vulnerableTo = setOf(),
                    resistantAgainst = setOf(),
                    weakTo = setOf(),
                    strongAgainst = setOf(),
                    noEffectiveTo = setOf(),
                    noAffectedAgainst = setOf()
                )
            ),
            Pokemon.Type(
                17, "dragon", Pokemon.Type.DamageRelations(
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
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/24.png"
    ),
    Pokemon(
        id = 132,
        name = "ditto",
        order = 203,
        height = 3,
        weight = 40,
        types = setOf(
            Pokemon.Type(
                11, "water", Pokemon.Type.DamageRelations(
                    vulnerableTo = setOf(),
                    resistantAgainst = setOf(),
                    weakTo = setOf(),
                    strongAgainst = setOf(),
                    noEffectiveTo = setOf(),
                    noAffectedAgainst = setOf()
                )
            ),
            Pokemon.Type(
                12, "grass", Pokemon.Type.DamageRelations(
                    vulnerableTo = setOf(),
                    resistantAgainst = setOf(),
                    weakTo = setOf(),
                    strongAgainst = setOf(),
                    noEffectiveTo = setOf(),
                    noAffectedAgainst = setOf()
                )
            ),
            Pokemon.Type(
                15, "ice", Pokemon.Type.DamageRelations(
                    vulnerableTo = setOf(),
                    resistantAgainst = setOf(),
                    weakTo = setOf(),
                    strongAgainst = setOf(),
                    noEffectiveTo = setOf(),
                    noAffectedAgainst = setOf()
                )
            ),
            Pokemon.Type(
                17, "dark", Pokemon.Type.DamageRelations(
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
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/132.png"
    )
)