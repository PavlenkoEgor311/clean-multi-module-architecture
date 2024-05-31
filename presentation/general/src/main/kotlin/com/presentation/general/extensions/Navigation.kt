package com.presentation.general.extensions

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.navigation.api.INavigator
import com.presentation.general.GeneralDetailedScreen
import com.presentation.general.GeneralScreen

const val general_route = "general"
const val general_detailed_route = "general_detailed"

fun NavGraphBuilder.generalNavigation(
    navController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit,
) {
    composable(general_route) {
        GeneralScreen(navController, navigator, setIsBottomBarVisible)
    }
    nestedGraphs()
}

fun NavGraphBuilder.generalDetailedScreen(
    navController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
) = composable(general_detailed_route) {
    GeneralDetailedScreen(navController, navigator, setIsBottomBarVisible)
}