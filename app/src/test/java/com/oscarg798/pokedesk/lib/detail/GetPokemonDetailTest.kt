package com.oscarg798.pokedesk.lib.detail

import androidx.compose.ui.graphics.Color
import com.oscarg798.pokedesk.detail.model.PokemonDetail
import com.oscarg798.pokedesk.detail.usecase.GetPokemonDetail
import com.oscarg798.pokedesk.lib.PokemonGenerator
import com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepositoryImpl
import com.oscarg798.pokedesk.lib.type.TypeRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetPokemonDetailTest {

    private val pokemonRepository = mockk<PokemonRepositoryImpl>()
    private val typeRepository = mockk<TypeRepository>()

    @Test
    fun `when invoke then return detail`() {
        val pokemon = PokemonGenerator.generatePokemon(1)
        coEvery { pokemonRepository.getPokemonDetail(pokemon.id) } answers { pokemon }
        coEvery {
            typeRepository.getColorFromType(
                pokemon.types.toList().first()
            )
        } answers { 0xff000000 }

        runTest {
            val result = GetPokemonDetail(pokemonRepository, typeRepository).invoke(pokemon.id)
            assertEquals(
                PokemonDetail(
                    id = pokemon.id,
                    name = pokemon.name,
                    order = pokemon.order,
                    height = pokemon.height,
                    weight = pokemon.weight,
                    types = pokemon.types.map() {
                        PokemonDetail.Type(
                            id = it.id,
                            name = it.name,
                            color = Color(0xff000000),
                            damageRelations = it.damageRelations
                        )
                    }.toSet(),
                    stats = pokemon.stats.map {
                        PokemonDetail.Stat(id = it.id, name = it.name, value = it.value)
                    }.toSet(),
                    image = pokemon.image
                ),
                result
            )
        }
        coVerify(exactly = 1) { pokemonRepository.getPokemonDetail(pokemon.id) }
    }
}
