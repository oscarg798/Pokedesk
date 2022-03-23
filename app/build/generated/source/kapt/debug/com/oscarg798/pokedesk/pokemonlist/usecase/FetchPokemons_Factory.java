// Generated by Dagger (https://dagger.dev).
package com.oscarg798.pokedesk.pokemonlist.usecase;

import com.oscarg798.pokedesk.lib.pokemon.repository.PokemonRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class FetchPokemons_Factory implements Factory<FetchPokemons> {
  private final Provider<PokemonRepository> pokemonRepositoryProvider;

  public FetchPokemons_Factory(Provider<PokemonRepository> pokemonRepositoryProvider) {
    this.pokemonRepositoryProvider = pokemonRepositoryProvider;
  }

  @Override
  public FetchPokemons get() {
    return newInstance(pokemonRepositoryProvider.get());
  }

  public static FetchPokemons_Factory create(
      Provider<PokemonRepository> pokemonRepositoryProvider) {
    return new FetchPokemons_Factory(pokemonRepositoryProvider);
  }

  public static FetchPokemons newInstance(PokemonRepository pokemonRepository) {
    return new FetchPokemons(pokemonRepository);
  }
}