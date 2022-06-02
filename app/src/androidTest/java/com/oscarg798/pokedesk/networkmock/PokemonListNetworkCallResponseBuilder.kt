package com.oscarg798.pokedesk.networkmock

import javax.inject.Inject
import okhttp3.Request

class PokemonListNetworkCallResponseBuilder @Inject constructor() :
    NetworkCallResponseBuilder("/responses/bulbasaur.json") {

    override fun shouldIntercept(request: Request): Boolean {
        return request.url.toString().contains("pokemon/1")
    }
}
