package com.oscarg798.pokedesk.di

import com.oscarg798.pokedesk.networkmock.NetworkCallResponseBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

@InstallIn(SingletonComponent::class)
@Module
object TestInterceptorModule {

    @IntoSet
    @Singleton
    @Provides
    fun provideRequestInterceptor(
        networkCallResponseBuilders: Set<@JvmSuppressWildcards NetworkCallResponseBuilder>
    ): Interceptor {
        return Interceptor {
            val request = it.request()
            val url = request.url.toString()

            networkCallResponseBuilders.firstOrNull { responseBuilder ->
                responseBuilder.shouldIntercept(request)
            }?.intercept(request) ?: errorResponse(url, request)
        }
    }

    private fun errorResponse(url: String, request: Request) =
        Response.Builder().code(500)
            .message("response not mocked for $url")
            .request(request)
            .protocol(Protocol.HTTP_2)
            .body(
                """
                    { "error" : "response not mocked for $url" } 
                """.trimIndent().toResponseBody()
            ).build()

    private fun jsonResponseToResponseBody(resourcePath: String) =
        this::class.java.getResource(resourcePath)!!.readText().toResponseBody()
}
