package com.oscarg798.pokedesk.detail.usecase

import androidx.compose.ui.graphics.Color
import com.oscarg798.pokedesk.detail.model.PokemonDetail
import com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository
import com.oscarg798.pokedesk.lib.type.TypeRepository
import javax.inject.Inject

class GetPokemonDetail @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val typeRepository: TypeRepository
) {

    suspend operator fun invoke(id: Int): PokemonDetail {
        val pokemon = pokemonRepository.getPokemonDetail(id)

        return PokemonDetail(
            pokemon.id,
            pokemon.name,
            pokemon.order,
            pokemon.height,
            pokemon.weight,
            pokemon.types.map {
                PokemonDetail.Type(it, Color(typeRepository.getColorFromType(it)))
            }.toSet(),
            pokemon.stats.map {
                PokemonDetail.Stat(it)
            }.toSet(),
            pokemon.image
        )
    }
}
