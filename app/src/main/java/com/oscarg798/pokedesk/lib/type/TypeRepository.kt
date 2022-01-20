package com.oscarg798.pokedesk.lib.type

import com.oscarg798.pokedesk.common.models.Pokemon
import java.lang.IllegalStateException
import javax.inject.Inject

class TypeRepository @Inject constructor(
    private val typeColorLoader: TypeColorLoader
) {

    private val pokemonTypeColors: Set<TypeColor> by lazy { typeColorLoader.getTypeColors() }

    fun getColorFromType(type: Pokemon.Type): Long {
        return pokemonTypeColors.firstOrNull { it.id == type.id }?.color
            ?.removePrefix(ColorARGBPrefix)
            ?.toLong(HexRadius) ?: throw IllegalStateException("We do not support type ${type.id}")
    }
}

private const val ColorARGBPrefix = "0x"
private const val HexRadius = 16