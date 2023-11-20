package com.kabos.navigation.logger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
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
    navController.debugLog()
    val currentBackStackEntry = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            MainBottomAppBar(
                navBackStackEntry = currentBackStackEntry.value,
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
    navBackStackEntry: NavBackStackEntry?,
    onClickHome: () -> Unit,
    onClickFavorite: () -> Unit,
    onClickSearch: () -> Unit,
) {
    BottomAppBar {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(),
        ) {
            BottomAppBarItem(
                onClick = onClickHome,
                isSelected = navBackStackEntry.isSelected(homeGraph),
                icon = Icons.Default.Home,
            )
            BottomAppBarItem(
                onClick = onClickFavorite,
                isSelected = navBackStackEntry.isSelected(favoriteGraph),
                icon = Icons.Default.Favorite,
            )
            BottomAppBarItem(
                onClick = onClickSearch,
                isSelected = navBackStackEntry.isSelected(searchGraph),
                icon = Icons.Default.Search,
            )
        }
    }
}

@Composable
fun BottomAppBarItem(
    onClick: () -> Unit,
    isSelected: Boolean,
    icon: ImageVector,
) {
    Box(
        modifier = Modifier
            .then(
                if (isSelected) Modifier.background(LightGray)
                else Modifier
            )
    ) {
        IconToggleButton(
            checked = isSelected,
            onCheckedChange = { onClick() },
        ) {
            Icon(imageVector = icon, contentDescription = null)
        }
    }
}
