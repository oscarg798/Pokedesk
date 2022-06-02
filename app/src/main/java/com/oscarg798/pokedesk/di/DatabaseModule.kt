package com.oscarg798.pokedesk.di

import android.content.Context
import androidx.room.Room
import com.oscarg798.pokedesk.lib.pokemon.persistence.PokeDexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PokeDexDatabase =
        Room.databaseBuilder(
            context,
            PokeDexDatabase::class.java, PokeDexDatabase::class.java.name
        ).build()
}