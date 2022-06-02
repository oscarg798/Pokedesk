package com.oscarg798.pokedesk.networkmock

import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

abstract class NetworkCallResponseBuilder(
    private val jsonResponsePath: String
) {

    abstract fun shouldIntercept(request: Request): Boolean

    fun intercept(request: Request): Response = Response.Builder().code(200)
        .request(request)
        .protocol(Protocol.HTTP_2)
        .message("")
        .body(
            jsonResponseToResponseBody().toResponseBody()
        ).build()

    private fun jsonResponseToResponseBody() =
        this::class.java.getResource(jsonResponsePath)!!.readText()
}
