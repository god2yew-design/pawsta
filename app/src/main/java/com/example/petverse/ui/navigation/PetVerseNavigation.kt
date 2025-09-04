package com.example.petverse.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.petverse.R
import com.example.petverse.ui.screens.auth.AuthScreen
import com.example.petverse.ui.screens.feed.FeedScreen
import com.example.petverse.ui.screens.profile.ProfileScreen
import com.example.petverse.ui.screens.services.ServicesScreen
import com.example.petverse.ui.screens.tours.ToursScreen
import com.example.petverse.ui.screens.videos.VideosScreen

data class TopLevelDestination(
    val route: String,
    val selectedIcon: @Composable () -> Unit,
    val unselectedIcon: @Composable () -> Unit,
    val iconTextId: Int
)

@Composable
fun PetVerseNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val topLevelDestinations = listOf(
        TopLevelDestination(
            route = NavigationRoutes.FEED,
            selectedIcon = { Icon(painterResource(R.drawable.ic_home_filled), null) },
            unselectedIcon = { Icon(painterResource(R.drawable.ic_home_outlined), null) },
            iconTextId = R.string.feed
        ),
        TopLevelDestination(
            route = NavigationRoutes.VIDEOS,
            selectedIcon = { Icon(painterResource(R.drawable.ic_video_filled), null) },
            unselectedIcon = { Icon(painterResource(R.drawable.ic_video_outlined), null) },
            iconTextId = R.string.videos
        ),
        TopLevelDestination(
            route = NavigationRoutes.SERVICES,
            selectedIcon = { Icon(painterResource(R.drawable.ic_services_filled), null) },
            unselectedIcon = { Icon(painterResource(R.drawable.ic_services_outlined), null) },
            iconTextId = R.string.services
        ),
        TopLevelDestination(
            route = NavigationRoutes.TOURS,
            selectedIcon = { Icon(painterResource(R.drawable.ic_map_filled), null) },
            unselectedIcon = { Icon(painterResource(R.drawable.ic_map_outlined), null) },
            iconTextId = R.string.tours
        ),
        TopLevelDestination(
            route = NavigationRoutes.PROFILE,
            selectedIcon = { Icon(painterResource(R.drawable.ic_profile_filled), null) },
            unselectedIcon = { Icon(painterResource(R.drawable.ic_profile_outlined), null) },
            iconTextId = R.string.profile
        )
    )

    val showBottomBar = topLevelDestinations.any { destination ->
        currentDestination?.hierarchy?.any { it.route == destination.route } == true
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    topLevelDestinations.forEach { destination ->
                        val selected = currentDestination?.hierarchy?.any {
                            it.route == destination.route
                        } == true

                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                navController.navigate(destination.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                if (selected) {
                                    destination.selectedIcon()
                                } else {
                                    destination.unselectedIcon()
                                }
                            },
                            label = { Text(stringResource(destination.iconTextId)) }
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.AUTH, // TODO: Change to appropriate start destination
            modifier = Modifier.padding(padding)
        ) {
            // Auth
            composable(NavigationRoutes.AUTH) {
                AuthScreen(navController = navController)
            }

            // Main screens
            composable(NavigationRoutes.FEED) {
                FeedScreen(navController = navController)
            }
            composable(NavigationRoutes.VIDEOS) {
                VideosScreen(navController = navController)
            }
            composable(NavigationRoutes.SERVICES) {
                ServicesScreen(navController = navController)
            }
            composable(NavigationRoutes.TOURS) {
                ToursScreen(navController = navController)
            }
            composable(NavigationRoutes.PROFILE) {
                ProfileScreen(navController = navController)
            }

            // TODO: Add other navigation destinations
        }
    }
}