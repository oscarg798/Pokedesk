package com.oscarg798.pokedesk.lib.network

import com.oscarg798.pokedesk.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @IntoSet
    @Provides
    fun provideLoggingInterceptor(): Interceptor = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    } else {
        Interceptor { chain -> chain.proceed(chain.request()) }
    }

    @Provides
    @Singleton
    fun provideHttpClient(
        interceptors: Set<@JvmSuppressWildcards Interceptor>
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(ConnectionTimeOut, TimeUnit.SECONDS)
            .readTimeout(ReadTimeOut, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        interceptors.forEach {
            builder.addInterceptor(it)
        }

        return builder.build()
    }
}

private const val ReadTimeOut = 30L
private const val ConnectionTimeOut = 30L
