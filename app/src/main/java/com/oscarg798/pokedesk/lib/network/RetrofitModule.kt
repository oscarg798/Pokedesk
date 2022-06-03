package com.oscarg798.pokedesk.lib.network

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Reusable
    @Provides
    fun providePokeApiRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        @PokeApiUrl
        baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @PokemonTcgRetrofit
    @Reusable
    @Provides
    fun providePokemonTcgRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson,
        @PokemonTcgUrl
        baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    @PokeApiUrl
    @Reusable
    @Provides
    fun providePokeApiUrl(): String = "https://pokeapi.co/api/v2/"

    @PokemonTcgUrl
    @Reusable
    @Provides
    fun providePokemonTcgUrl(): String = "https://api.pokemontcg.io/v2/"
}

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class PokeApiUrl

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class PokemonTcgUrl

@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class PokemonTcgRetrofit
