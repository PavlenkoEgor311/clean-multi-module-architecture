package com.presentation.auth.extensions

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.navigation.api.INavigator
import com.presentation.auth.AuthScreen

const val auth_route = "auth"

fun NavGraphBuilder.authScreen(
    navController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
) = composable(auth_route) {
    AuthScreen(navController, navigator, setIsBottomBarVisible)
}