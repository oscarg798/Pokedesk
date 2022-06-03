package com.oscarg798.pokedesk.lib.pokemoncardimages

import com.oscarg798.pokedesk.pokemoncardimages.model.PokemonCardImages
import java.util.UUID

object PokemonCardImagesGenerator {

    fun generateCardImages() = (0 until 5).map {
        PokemonCardImages(
            id = UUID.randomUUID().toString(),
            name = UUID.randomUUID().toString(),
            images = PokemonCardImages.Images(
                large = UUID.randomUUID().toString(),
                small = UUID.randomUUID().toString()
            )
        )
    }
}
