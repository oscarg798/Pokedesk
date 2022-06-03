package com.oscarg798.pokedesk.pokemoncardimages.usecase

import com.oscarg798.pokedesk.pokemoncardimages.repository.PokemonTCGRepository
import javax.inject.Inject

class GetPokemonCardImages @Inject constructor(
    private val pokemonTCGRepository: PokemonTCGRepository
) {

    suspend operator fun invoke(name: String) = pokemonTCGRepository.getPokemonCardImagesFromPokemonName(name)
}
