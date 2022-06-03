package com.oscarg798.pokedesk.lib.pokemoncardimages

import com.oscarg798.pokedesk.pokemoncardimages.repository.PokemonTCGRepository
import com.oscarg798.pokedesk.pokemoncardimages.usecase.GetPokemonCardImages
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import java.util.UUID
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class GetPokemonCardImagesTest {

    private val repository: PokemonTCGRepository = mockk()

    @Test
    fun `given a name when invoke called then it should return what repo returns for that name`() = runTest {
        val images = generateCardImages()
        val name = UUID.randomUUID().toString()
        coEvery { repository.getPokemonCardImagesFromPokemonName(name) } answers { images }

        val result = GetPokemonCardImages(repository)(name)

        Assert.assertEquals(images, result)
        coVerify(exactly = 1) {
            repository.getPokemonCardImagesFromPokemonName(name)
        }
    }

    private fun generateCardImages() = PokemonCardImagesGenerator.generateCardImages()
}
