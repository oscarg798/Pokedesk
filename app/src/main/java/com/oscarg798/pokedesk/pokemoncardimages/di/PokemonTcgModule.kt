package com.oscarg798.pokedesk.pokemoncardimages.di

import com.oscarg798.pokedesk.lib.network.PokemonTcgRetrofit
import com.oscarg798.pokedesk.pokemoncardimages.network.PokemonTcgService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object PokemonTcgModule {

    @Reusable
    @Provides
    fun providePokemonCardImageService(
        @PokemonTcgRetrofit
        retrofit: Retrofit
    ): PokemonTcgService = retrofit.create(PokemonTcgService::class.java)
}
