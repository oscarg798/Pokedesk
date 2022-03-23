package com.oscarg798.pokedesk.di

import com.oscarg798.pokedesk.networkmock.NetworkCallResponseBuilder
import com.oscarg798.pokedesk.networkmock.PokemonDetailNetworkCallResponseBuilder
import com.oscarg798.pokedesk.networkmock.PokemonListNetworkCallResponseBuilder
import com.oscarg798.pokedesk.networkmock.TypeNetworkCallResponseBuilder
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
abstract class NetworkCallResponseBuilderModule {

    @IntoSet
    @Binds
    abstract fun bindPokemonListResponseBuilder(
        pokemonListNetworkCallResponseBuilder: PokemonListNetworkCallResponseBuilder
    ): NetworkCallResponseBuilder

    @IntoSet
    @Binds
    abstract fun bindPokemonDetailResponseBuilder(
        pokemonDetailNetworkCallResponseBuilder: PokemonDetailNetworkCallResponseBuilder
    ): NetworkCallResponseBuilder

    @IntoSet
    @Binds
    abstract fun bindPokemonTypeResponseBuilder(
        typeNetworkCallResponseBuilder: TypeNetworkCallResponseBuilder
    ): NetworkCallResponseBuilder
}
