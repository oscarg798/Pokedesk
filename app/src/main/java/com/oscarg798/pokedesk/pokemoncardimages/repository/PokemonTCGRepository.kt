package com.oscarg798.pokedesk.pokemoncardimages.repository

import com.oscarg798.pokedesk.pokemoncardimages.model.PokemonCardImages
import com.oscarg798.pokedesk.pokemoncardimages.network.PokemonTcgService
import javax.inject.Inject

class PokemonTCGRepository @Inject constructor(
    private val pokemonCardImagesService: PokemonTcgService,
) {

    suspend fun getPokemonCardImagesFromPokemonName(name: String): List<PokemonCardImages> {
        return pokemonCardImagesService.getCardImagesFromPokemonName("name:$name").data.map {
            it.toPokemonCardImages()
        }
    }
}
