package com.oscarg798.pokedesk.lib.pokemon.model

import com.google.gson.annotations.SerializedName

data class ApiPokemon(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("types")
    val types: List<APIType>,
    @SerializedName("stats")
    val stats: List<ApiStat>,
    @SerializedName("sprites")
    val image: ApiImages
) {

    data class ApiImages(
        @SerializedName("other")
        val artWork: ArtWork
    ) {

        data class ArtWork(
            @SerializedName("official-artwork")
            val detail: Detail
        ) {
            data class Detail(
                @SerializedName("front_default")
                val url: String
            )
        }
    }

    data class ApiStat(
        @SerializedName("base_stat")
        val value: Int,
        @SerializedName("stat")
        val statInfo: ApiStatInfo
    ) {

        fun toStat() = Pokemon.Stat(
            id = statInfo.url.split("/").take(2).first().toInt(),
            name = statInfo.name,
            value = value
        )

        data class ApiStatInfo(
            @SerializedName("url")
            val url: String,
            @SerializedName("name")
            val name: String
        )
    }
}