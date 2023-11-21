package com.kabos.navigation.logger

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navigation

const val homeGraph = "home_graph"
const val favoriteGraph = "favorite_graph"
const val searchGraph = "search_graph"

const val homeScreenA = "home_screen_a"
const val homeScreenB = "home_screen_b"
const val homeScreenC = "home_screen_c"
const val favoriteScreenA = "favorite_screen_a"
const val searchScreenA = "search_screen_a"

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    startDestination: String = homeGraph,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        homeGraph(navController = navHostController)
        favoriteGraph(navController = navHostController)
        searchGraph()
    }
}

fun NavGraphBuilder.homeGraph(
    navController: NavController,
) {
    navigation(
        route = homeGraph,
        startDestination = homeScreenA,
    ) {
        composable(homeScreenA) {
            Screen(
                title = "Home Screen A",
                buttonTitle = "home screen B",
                onClick = { navController.navigate(homeScreenB) }
            )
        }
        composable(homeScreenB) {
            Screen(
                title = "Home Screen B",
                buttonTitle = "home screen C",
                onClick = { navController.navigate(homeScreenC) }
            )
        }
        composable(homeScreenC) {
            Screen(
                title = "Home Screen C",
                buttonTitle = "home screen A",
                onClick = { navController.navigate(homeScreenA) }
            )
        }
    }
}

fun NavGraphBuilder.favoriteGraph(
    navController: NavController,
) {
    navigation(
        route = favoriteGraph,
        startDestination = favoriteScreenA,
    ) {
        composable(favoriteScreenA) {
            Screen(
                title = "Favorite Screen A",
                onClick = { navController.navigate(homeScreenB) }
            )
        }
    }
}

fun NavGraphBuilder.searchGraph() {
    navigation(
        route = searchGraph,
        startDestination = searchScreenA,
    ) {
        composable(searchScreenA) {
            Screen(title = "Search Screen A")
        }
    }
}

@Composable
fun NavController.DebugLog() {
    val backStackEntry = currentBackStackEntryAsState().value
    Log.d("Navigation BackStackEntry", "${backStackEntry?.toLog()}")
}

fun NavBackStackEntry.toLog(): String {
    return """
        - NavDestination
            - id: ${destination.id}
            - route: ${destination.route}
            - arguments: ${destination.arguments}
            - parent: ${destination.parent?.toLog()}
    """
}

fun NavGraph.toLog(): String {
    return """
        - NavGraph
            - route: $route
            - startDestinationRoute: $startDestinationRoute
            - node: ${this.nodes}
            - parent: ${parent?.toLog()}
    """.prependIndent()
}

fun NavBackStackEntry?.isSelected(graph: String): Boolean {
    Log.d("Navigation back", "${this?.destination?.parent}")
    return this?.destination?.parent?.route == graph
}
