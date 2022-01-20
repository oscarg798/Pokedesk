package com.oscarg798.pokedesk.lib.pokemon

import com.oscarg798.pokedesk.common.models.Pokemon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(){

    fun getPokemons(): List<Pokemon> = listOf(
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
}