package com.oscarg798.pokedesk.lib.pokemon.utils

import dagger.Reusable
import javax.inject.Inject

@Reusable
class IdExtractor @Inject constructor() {

    fun getIdFromUrl(url: String): Int {
        if (!url.endsWith(SplitToken)) {
            throw IllegalArgumentException("We cannot extract id from an url not ending in '/'")
        }

        val slices = url.split(SplitToken)

        if (slices.size < 2) {
            throw IllegalArgumentException("Url does not have the right pattern it should end up like '/12/'")
        }

        val id = slices.takeLast(2).first()

        return id.toIntOrNull() ?: throw IllegalArgumentException("We were not able to extract the id, are you sure its an id $id")
    }
}

private val SplitToken = "/"
