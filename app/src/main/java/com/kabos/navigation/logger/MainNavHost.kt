package com.kabos.navigation.logger

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

const val homeGraph = "home_graph"
const val favoriteGraph = "favorite_graph"
const val searchGraph = "search_graph"

const val homeScreenA = "home_screen_a"
const val homeScreenB = "home_screen_b"
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
        favoriteGraph()
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
                buttonTitle = "",
                onClick = { navController.navigate(homeScreenB) }
            )
        }
    }
}

fun NavGraphBuilder.favoriteGraph() {
    navigation(
        route = favoriteGraph,
        startDestination = favoriteScreenA,
    ) {
        composable(favoriteScreenA) {
            Screen(title = "Favorite Screen A")
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
