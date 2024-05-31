package com.presentation.splash.extensions

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.navigation.api.INavigator
import com.presentation.splash.SplashScreen

const val splash_route = "splash"

fun NavGraphBuilder.splashScreen(
    navController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
) = composable(splash_route) {
    SplashScreen(navController, navigator, setIsBottomBarVisible)
}