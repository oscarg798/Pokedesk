package com.oscarg798.pokedesk.di

import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideCoroutineContextProvider(): CoroutineContextProvider = object : CoroutineContextProvider {
        override val io: CoroutineContext
            get() = Dispatchers.IO
        override val computation: CoroutineContext
            get() = Dispatchers.Default
        override val main: CoroutineContext
            get() = Dispatchers.Main
    }
}
