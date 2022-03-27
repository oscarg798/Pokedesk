package com.oscarg798.pokedesk;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = PokeApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface PokeApp_GeneratedInjector {
  void injectPokeApp(PokeApp pokeApp);
}
