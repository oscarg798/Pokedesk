package com.oscarg798.pokedesk.networkmock

import javax.inject.Inject
import okhttp3.Request

class PokemonDetailNetworkCallResponseBuilder @Inject constructor() :
    NetworkCallResponseBuilder("/responses/pokemon_list_response.json") {

    override fun shouldIntercept(request: Request): Boolean {
        val url = request.url.toString()
        return url.contains("pokemon") && url.contains("limit")
    }
}
