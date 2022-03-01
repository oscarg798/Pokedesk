package com.oscarg798.pokedesk.detail

import android.net.Uri
import android.os.Bundle
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.oscarg798.pokedesk.lib.navigation.Route

object PokemonDetailRoute : Route(route = Route, uriPatternSuffix = UriPatternSuffix) {

    override fun getDeeplinkNavigationRoute(arguments: Bundle?): Uri {
        require(arguments != null && arguments.containsKey(IdArgument))
        return getUriPattern().replace(
            "{$IdArgument}",
            arguments.getInt(
                IdArgument
            ).toString()
        ).toUri()
    }

    fun navigate(id: Int, navController: NavController) {
        navigate(
            navController,
            Bundle().apply {
                putInt(IdArgument, id)
            }
        )
    }

    const val IdArgument = "id"
}

private const val Route = "pokemonDetail"
private const val UriPatternSuffix = "$Route/{${PokemonDetailRoute.IdArgument}}"
