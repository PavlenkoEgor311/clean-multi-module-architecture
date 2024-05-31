package com.presentation.home.extensions

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.navigation.api.INavigator
import com.presentation.home.HomeDetailedScreen
import com.presentation.home.HomeScreen

const val home_route = "home"
const val home_detailed_route = "home_detailed"

fun NavGraphBuilder.homeNavigation(
    navController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    composable(home_route) {
        HomeScreen(navController, navigator, setIsBottomBarVisible)

    }
    nestedGraphs()
}

fun NavGraphBuilder.homeDetailedScreen(
    navController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
) = composable(home_detailed_route) {
    HomeDetailedScreen(navController, navigator, setIsBottomBarVisible)
}