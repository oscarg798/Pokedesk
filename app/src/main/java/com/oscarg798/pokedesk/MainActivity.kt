package com.oscarg798.pokedesk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.oscarg798.pokedesk.lib.ui.PokeDeskTheme
import com.oscarg798.pokedesk.pokemonlist.navigation.PokemonListRoute
import com.oscarg798.pokedesk.pokemonlist.ui.pokemonScreen
import com.oscarg798.pokedesk.splash.animationForSplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setOnExitAnimationListener { splashScreenView ->
            animationForSplashScreen(splashScreenView)
        }
        setContent {
            val navController = rememberNavController()
            PokeDeskTheme {
                CompositionLocalProvider(LocalNavControllerProvider provides navController) {
                    NavHost(navController = navController, startDestination = PokemonListRoute.route) {
                        pokemonScreen()
                    }
                }
            }
        }
    }
}

internal val LocalNavControllerProvider = staticCompositionLocalOf<NavController> {
    error("You must provide a NavController before attempt to use it")
}
