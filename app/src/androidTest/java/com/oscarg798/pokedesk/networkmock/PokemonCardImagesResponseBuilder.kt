package com.oscarg798.pokedesk.networkmock

import javax.inject.Inject
import okhttp3.Request

class PokemonCardImagesResponseBuilder @Inject constructor() :
    NetworkCallResponseBuilder("/responses/card_images.json") {

    override fun shouldIntercept(request: Request): Boolean {
        return request.url.toString().contains("cards?q=name%3ACharmander")
    }
}
