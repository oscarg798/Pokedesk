package com.oscarg798.pokedesk.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UtilModule {

    @Reusable
    @Provides
    fun provideGson(): Gson = Gson()
}
