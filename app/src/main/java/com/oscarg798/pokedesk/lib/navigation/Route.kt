package com.oscarg798.pokedesk.lib.navigation

import android.net.Uri
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navOptions

abstract class Route(
    val route: String,
    private val uriPatternSuffix: String
) {
    init {
        if (uriPatternSuffix.startsWith("/")) {
            throw IllegalStateException("Uri Pattern suffix should not include '/' character")
        }
    }

    protected open fun getDeeplinkNavigationRoute(arguments: Bundle? = null): Uri {
        return getUriPattern().toUri()
    }

    fun navigate(navController: NavController, arguments: Bundle? = null) {
        navController.navigate(
            getDeeplinkNavigationRoute(arguments),
            navOptions {
                this.launchSingleTop = true
            }
        )
    }

    fun getDeepLinks(): List<NavDeepLink> = listOf(
        navDeepLink {
            uriPattern = getUriPattern()
        }
    )

    private fun getUriPattern() = "$DeepLinkUri/$uriPatternSuffix"
}

fun <T : Route> NavGraphBuilder.composable(
    route: T,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(route.route, deepLinks = route.getDeepLinks()) {
        content(it)
    }
}

private const val DeepLinkUri = "https://pokedesk/"
