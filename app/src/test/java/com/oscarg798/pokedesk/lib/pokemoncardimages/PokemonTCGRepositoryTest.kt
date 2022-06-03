package com.oscarg798.pokedesk.lib.pokemoncardimages

import com.oscarg798.pokedesk.pokemoncardimages.model.ApiPokemonCardImages
import com.oscarg798.pokedesk.pokemoncardimages.model.PokemonCardImages
import com.oscarg798.pokedesk.pokemoncardimages.network.PokemonTcgService
import com.oscarg798.pokedesk.pokemoncardimages.repository.PokemonTCGRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import java.util.UUID
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PokemonTCGRepositoryTest {

    private val pokemonTcgService: PokemonTcgService = mockk()
    private lateinit var repository: PokemonTCGRepository

    @Before
    fun setup() {
        repository = PokemonTCGRepository(pokemonTcgService)
    }

    @Test
    fun `given a pokemon name when getPokemonCardImagesFromPokemonName invoke then return images`() =
        runTest {
            val pokemonName = UUID.randomUUID().toString()
            val apiCardImages = generatePokemonImages()
            val nameQuery = "name:$pokemonName"

            coEvery { pokemonTcgService.getCardImagesFromPokemonName(nameQuery) } answers { apiCardImages }

            val expected = apiCardImages.data.map {
                PokemonCardImages(
                    it.id,
                    it.name,
                    PokemonCardImages.Images(
                        large = it.images.large,
                        small = it.images.small
                    )
                )
            }

            val images = repository.getPokemonCardImagesFromPokemonName(name = pokemonName)

            Assert.assertEquals(expected, images)

            coVerify(exactly = 1) {
                pokemonTcgService.getCardImagesFromPokemonName(nameQuery)
            }
        }

    private fun generatePokemonImages() = PokemonTcgService.PokemonCardImagesResponse(
        data = (0 until 5).map {
            ApiPokemonCardImages(
                id = UUID.randomUUID().toString(),
                name = UUID.randomUUID().toString(),
                images = ApiPokemonCardImages.Images(
                    large = UUID.randomUUID().toString(),
                    small = UUID.randomUUID().toString()
                )
            )
        }
    )
}
