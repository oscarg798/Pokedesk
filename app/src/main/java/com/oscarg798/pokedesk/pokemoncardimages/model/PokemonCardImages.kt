package com.oscarg798.pokedesk.pokemoncardimages.model

data class PokemonCardImages(
    val id: String,
    val name: String,
    val images: Images
) {

    data class Images(
        val small: String,
        val large: String
    )
}
