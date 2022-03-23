package com.oscarg798.pokedesk.detail.ui;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.codegen.OriginatingElement;

@OriginatingElement(
    topLevelClass = PokemonDetailEntryPoint.class
)
@EntryPoint
@InstallIn(ActivityComponent.class)
public interface HiltWrapper_PokemonDetailEntryPoint extends PokemonDetailEntryPoint {
}
