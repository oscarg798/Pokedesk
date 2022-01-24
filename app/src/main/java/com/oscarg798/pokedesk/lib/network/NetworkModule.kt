package com.oscarg798.pokedesk.lib.network

import com.google.gson.Gson
import com.oscarg798.pokedesk.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

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
       val builder =  OkHttpClient.Builder()
            .connectTimeout(ConnectionTimeOut, TimeUnit.SECONDS)
            .readTimeout(ReadTimeOut, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        interceptors.forEach {
            builder.addInterceptor(it)
        }

        return builder.build()
    }

    @Reusable
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit = Retrofit.Builder()
        .baseUrl(AuthUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()
}

private const val AuthUrl = "https://pokeapi.co/api/v2/"
private const val ReadTimeOut = 30L
private const val ConnectionTimeOut = 30L