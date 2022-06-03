package com.oscarg798.pokedesk.pokemoncardimages.model

import com.google.gson.annotations.SerializedName

data class ApiPokemonCardImages(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("images")
    val images: Images
) {

    data class Images(
        @SerializedName("small")
        val small: String,
        @SerializedName("large")
        val large: String
    )

    fun toPokemonCardImages(): PokemonCardImages = PokemonCardImages(
        id = id,
        name = name,
        images = PokemonCardImages.Images(
            small = images.small,
            large = images.large
        )
    )
}
