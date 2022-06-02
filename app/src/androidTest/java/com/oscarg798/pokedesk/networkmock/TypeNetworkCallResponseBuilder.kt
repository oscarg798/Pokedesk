package com.oscarg798.pokedesk.networkmock

import javax.inject.Inject
import okhttp3.Request

class TypeNetworkCallResponseBuilder @Inject constructor() :
    NetworkCallResponseBuilder("/responses/type_one.json") {

    override fun shouldIntercept(request: Request): Boolean {
        return request.url.toString().contains("type")
    }
}
