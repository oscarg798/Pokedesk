package com.oscarg798.pokedesk.lib.type.di

import com.oscarg798.pokedesk.lib.type.TypeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object TypeModule {

    @Provides
    fun provideTypeRepository(retrofit: Retrofit): TypeService =
        retrofit.create(TypeService::class.java)
}
