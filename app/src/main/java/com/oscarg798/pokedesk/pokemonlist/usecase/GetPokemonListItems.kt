package com.oscarg798.pokedesk.pokemonlist.usecase

import androidx.compose.ui.graphics.Color
import com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository
import com.oscarg798.pokedesk.lib.type.TypeRepository
import com.oscarg798.pokedesk.pokemonlist.model.PokemonListItem
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Reusable
class GetPokemonListItems @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val typeRepository: TypeRepository
) {

    operator fun invoke(): Flow<List<PokemonListItem>> {
        return pokemonRepository.getPokemons().map { pokemons ->
            pokemons.map {
                PokemonListItem(
                    id = it.id,
                    name = it.name,
                    order = it.order,
                    image = it.image,
                    types = it.types.map { pokemonType ->
                        PokemonListItem.Type(
                            pokemonType.id,
                            pokemonType.name,
                            Color(typeRepository.getColorFromType(pokemonType))
                        )
                    }.toSet()
                )
            }.sortedBy { pokemonListItem ->
                pokemonListItem.id
            }
        }
    }
}
