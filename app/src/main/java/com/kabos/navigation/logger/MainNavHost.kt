package com.kabos.navigation.logger

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavHost(
    navHostController: NavHostController,
    startDestination: String = "screen_a",
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        composable("screen_a") {
            Text(text = "Screen A")
        }
    }
}
