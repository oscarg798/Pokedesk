package com.oscarg798.pokedesk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.oscarg798.pokedesk.pokemonlist.GetPokemonListItems
import com.oscarg798.pokedesk.pokemonlist.ui.PokemonListCard
import com.oscarg798.pokedesk.pokemonlist.PokemonListItem
import com.oscarg798.pokedesk.ui.theme.PokedeskTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var getPokemonListItems: GetPokemonListItems

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val pokemonListItem: MutableState<List<PokemonListItem>> =
                remember { mutableStateOf(listOf()) }

            LaunchedEffect(getPokemonListItems) {
                launch {
                    pokemonListItem.value = getPokemonListItems()
                }
            }

            PokedeskTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color(0xff242424)) {

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(pokemonListItem.value, key = {
                            it.id
                        }) {
                            PokemonListCard(pokemon = it)
                        }
                    }

                }
            }
        }
    }
}