// Generated by Dagger (https://dagger.dev).
package com.oscarg798.pokedesk.detail.ui;

import com.oscarg798.pokedesk.detail.usecase.GetPokemonDetail;
import com.oscarg798.pokedesk.lib.definitions.CoroutineContextProvider;
import dagger.internal.DaggerGenerated;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PokemonDetailViewModel_Factory {
  private final Provider<GetPokemonDetail> getPokemonDetailProvider;

  private final Provider<CoroutineContextProvider> coroutineContextProvider;

  public PokemonDetailViewModel_Factory(Provider<GetPokemonDetail> getPokemonDetailProvider,
      Provider<CoroutineContextProvider> coroutineContextProvider) {
    this.getPokemonDetailProvider = getPokemonDetailProvider;
    this.coroutineContextProvider = coroutineContextProvider;
  }

  public PokemonDetailViewModel get(int id) {
    return newInstance(id, getPokemonDetailProvider.get(), coroutineContextProvider.get());
  }

  public static PokemonDetailViewModel_Factory create(
      Provider<GetPokemonDetail> getPokemonDetailProvider,
      Provider<CoroutineContextProvider> coroutineContextProvider) {
    return new PokemonDetailViewModel_Factory(getPokemonDetailProvider, coroutineContextProvider);
  }

  public static PokemonDetailViewModel newInstance(int id, GetPokemonDetail getPokemonDetail,
      CoroutineContextProvider coroutineContextProvider) {
    return new PokemonDetailViewModel(id, getPokemonDetail, coroutineContextProvider);
  }
}
