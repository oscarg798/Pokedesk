package com.oscarg798.pokedesk.pokemonlist.usecase

import com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository
import javax.inject.Inject

class FetchPokemons @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(offset: Int) {
        pokemonRepository.fetchPokemons(offset)
    }
}
