package com.oscarg798.pokedesk.lib.pokemon.model

import com.google.gson.annotations.SerializedName

data class ApiType(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("damage_relations")
    val damageRelations: ApiDamageRelation
) {
    data class ApiDamageRelation(
        @SerializedName("double_damage_from")
        val vulnerableTo: List<ApiDamageRelationType>,
        @SerializedName("double_damage_to")
        val resistantAgainst: List<ApiDamageRelationType>,
        @SerializedName("half_damage_from")
        val weakTo: List<ApiDamageRelationType>,
        @SerializedName("half_damage_to")
        val strongAgainst: List<ApiDamageRelationType>,
        @SerializedName("no_damage_to")
        val noEffectiveTo: List<ApiDamageRelationType>,
        @SerializedName("no_damage_from")
        val noAffectedAgainst: List<ApiDamageRelationType>
    ) {

        data class ApiDamageRelationType(
            @SerializedName("url")
            val url: String,
            @SerializedName("name")
            val name: String
        )
    }
}
