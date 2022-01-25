package com.oscarg798.pokedesk.lib.pokemon.di

import com.oscarg798.pokedesk.lib.pokemon.network.PokemonService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object PokemonModule {

    @Reusable
    @Provides
    fun providePokemonService(retrofit: Retrofit): PokemonService = retrofit.create(PokemonService::class.java)
}
