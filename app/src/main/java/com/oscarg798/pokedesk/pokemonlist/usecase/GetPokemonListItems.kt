package com.oscarg798.pokedesk.pokemonlist.usecase

import androidx.compose.ui.graphics.Color
import com.oscarg798.pokedesk.lib.pokemon.PokemonRepository
import com.oscarg798.pokedesk.lib.type.TypeRepository
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import dagger.Reusable
import javax.inject.Inject

@Reusable
class GetPokemonListItems @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val typeRepository: TypeRepository
) {

    operator fun invoke(): List<PokemonListItem> {
        return pokemonRepository.getPokemons().map {
            PokemonListItem(
                it.id,
                it.name,
                it.order,
                it.image,
                it.types.map { pokemonType ->
                    PokemonListItem.Type(
                        pokemonType.id,
                        pokemonType.name,
                        Color(typeRepository.getColorFromType(pokemonType))
                    )
                }.toSet()
            )
        }
    }
}