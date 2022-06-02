package com.oscarg798.pokedesk.di

import android.content.Context
import androidx.room.Room
import com.oscarg798.pokedesk.lib.pokemon.persistence.PokeDexDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [SingletonComponent::class], replaces = [DatabaseModule::class])
@Module
object TestDatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): PokeDexDatabase {
        return Room.inMemoryDatabaseBuilder(context, PokeDexDatabase::class.java).build()
    }
}
