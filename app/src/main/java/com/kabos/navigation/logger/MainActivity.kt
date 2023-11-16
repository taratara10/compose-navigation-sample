package com.kabos.navigation.logger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            MainBottomAppBar(
                onClickHome = {
                    navController.navigate(homeGraph) {

                    }
                },
                onClickFavorite = { navController.navigate(favoriteGraph) },
                onClickSearch = { navController.navigate(searchGraph) },
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            MainNavHost(navHostController = navController)
        }
    }
}

@Composable
fun MainBottomAppBar(
    onClickHome: () -> Unit,
    onClickFavorite: () -> Unit,
    onClickSearch: () -> Unit,
) {
    BottomAppBar {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(
                onClick = onClickHome,
                content = {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "home")
                }
            )
            IconButton(
                onClick = onClickFavorite,
                content = {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "favorite")
                }
            )
            IconButton(
                onClick = onClickSearch,
                content = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                }
            )
        }
    }
}
