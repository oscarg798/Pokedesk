package com.oscarg798.pokedesk

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.oscarg798.pokedesk.lib.ui.PokeDeskTheme
import com.oscarg798.pokedesk.pokemonlist.navigation.PokemonListRoute
import com.oscarg798.pokedesk.pokemonlist.usecase.GetPokemonListItems
import com.oscarg798.pokedesk.pokemonlist.ui.pokemonScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var getPokemonListItems: GetPokemonListItems

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

private fun animationForSplashScreen(splashScreenView: SplashScreenViewProvider) {
    val alpha = ObjectAnimator.ofFloat(
        splashScreenView.view,
        View.ALPHA,
        1f,
        0f
    )
    alpha.duration = 3000L
    alpha.doOnEnd { splashScreenView.remove() }
    alpha.start()
}

internal val LocalNavControllerProvider = staticCompositionLocalOf<NavController> {
    error("You must provide a NavController before attempt to use it")
}