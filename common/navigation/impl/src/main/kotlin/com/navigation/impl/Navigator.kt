package com.navigation.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import com.navigation.api.INavigator
import com.presentation.auth.extensions.auth_route
import com.presentation.general.extensions.general_detailed_route
import com.presentation.general.extensions.general_route
import com.presentation.home.extensions.home_detailed_route
import com.presentation.home.extensions.home_route
import com.presentation.settings.extensions.settings_detailed_route
import com.presentation.settings.extensions.settings_route
import com.presentation.splash.extensions.splash_route
import extensions.safeNavigate

class Navigator : INavigator {

    private val topLevelNavOptions = navOptions {
        popUpTo(root_graph_route) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

    override fun navigateToAuth(
        navController: NavHostController,
        modifier: Modifier
    ) = navController.safeNavigate(
        navController = navController,
        route = auth_route,
        navOptions = navOptions {
            popUpTo(splash_route) { inclusive = true }
        }
    )

    override fun navigateToSettings(
        navController: NavHostController,
        modifier: Modifier,
    ) = navController.safeNavigate(navController, settings_route, topLevelNavOptions)

    override fun navigateToHome(
        navController: NavHostController,
        modifier: Modifier,
    ) = navController.safeNavigate(navController, home_route, topLevelNavOptions)

    override fun navigateToGeneral(
        navController: NavHostController,
        modifier: Modifier,
    ) = navController.safeNavigate(navController, general_route, topLevelNavOptions)

    override fun navigateToSettingsDetailed(
        navController: NavHostController,
        modifier: Modifier,
    ) = navController.safeNavigate(navController, settings_detailed_route)

    override fun navigateToHomeDetailed(
        navController: NavHostController,
        modifier: Modifier,
    ) = navController.safeNavigate(navController, home_detailed_route)

    override fun navigateToGeneralDetailed(
        navController: NavHostController,
        modifier: Modifier,
    ) = navController.safeNavigate(navController, general_detailed_route)
}