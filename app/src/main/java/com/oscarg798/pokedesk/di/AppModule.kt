package com.oscarg798.pokedesk.di

import android.content.Context
import androidx.room.Room
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import com.oscarg798.pokedesk.lib.pokemon.persistence.PokeDexDatabase
import com.oscarg798.pokedesk.lib.pokemon.persistence.PokemonDao
import com.oscarg798.pokedesk.lib.pokemon.persistence.StatsDao
import com.oscarg798.pokedesk.lib.pokemon.persistence.TypeDao
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Reusable
    @Provides
    fun providePokemonDao(pokeDexDatabase: PokeDexDatabase): PokemonDao =
        pokeDexDatabase.pokemonDao()

    @Reusable
    @Provides
    fun providePokemonTypeDao(pokeDexDatabase: PokeDexDatabase): TypeDao = pokeDexDatabase.typeDao()

    @Reusable
    @Provides
    fun providePokemonStatDao(pokeDexDatabase: PokeDexDatabase): StatsDao =
        pokeDexDatabase.statDao()
}
