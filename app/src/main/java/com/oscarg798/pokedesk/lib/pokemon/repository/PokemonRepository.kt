package com.oscarg798.pokedesk.lib.pokemon.repository

import com.oscarg798.pokedesk.lib.pokemon.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemons(): Flow<List<Pokemon>>

    suspend fun fetchPokemons(offSet: Int)

    suspend fun getPokemonDetail(id: Int): Pokemon
}
