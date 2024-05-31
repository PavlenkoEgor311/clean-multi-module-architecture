package com.presentation.settings.extensions

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.navigation.api.INavigator
import com.presentation.settings.SettingsDetailedScreen
import com.presentation.settings.SettingsScreen

const val settings_route = "settings"
const val settings_detailed_route = "settings_detailed"

fun NavGraphBuilder.settingsNavigation(
    navController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    composable(settings_route) {
        SettingsScreen(navController, navigator, setIsBottomBarVisible)
    }
    nestedGraphs()
}

fun NavGraphBuilder.settingsDetailedScreen(
    navController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
) = composable(settings_detailed_route) {
    SettingsDetailedScreen(navController, navigator, setIsBottomBarVisible)
}