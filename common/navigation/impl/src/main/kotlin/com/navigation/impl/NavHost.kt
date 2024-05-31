package com.navigation.impl

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.presentation.auth.extensions.authScreen
import com.presentation.general.extensions.generalDetailedScreen
import com.presentation.general.extensions.generalNavigation
import com.presentation.home.extensions.homeDetailedScreen
import com.presentation.home.extensions.homeNavigation
import com.presentation.settings.extensions.settingsDetailedScreen
import com.presentation.settings.extensions.settingsNavigation
import com.presentation.splash.extensions.splashScreen
import com.presentation.splash.extensions.splash_route

const val root_graph_route = "root_graph"

@Composable
fun NavHost(navController: NavHostController) {
    val navigator = Navigator()
    var isBottomBarVisible by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {},
        snackbarHost = {},
        bottomBar = {
            Box(modifier = Modifier.fillMaxWidth()) {
                AnimatedVisibility(
                    visible = isBottomBarVisible,
                    enter = slideInVertically { it } + fadeIn(),
                    exit = slideOutVertically { it } + fadeOut(),
                ) {
                    BottomBar(
                        navController = navController,
                        currentDestination = navController.currentBackStackEntry?.destination,
                        navigator = navigator,
                    )
                }
            }
        },
    ) { paddingValues ->
        NavHostApp(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            navigator = navigator,
            navController = navController,
            setIsBottomBarVisible = { isBottomBarVisible = it },
        )
    }
}

@Composable
private fun NavHostApp(
    modifier: Modifier,
    navigator: Navigator,
    navController: NavHostController,
    setIsBottomBarVisible: (Boolean) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = splash_route,
        route = root_graph_route,
    ) {
        splashScreen(navController, navigator, setIsBottomBarVisible)
        authScreen(navController, navigator, setIsBottomBarVisible)
        settingsNavigation(navController, navigator, setIsBottomBarVisible) {
            settingsDetailedScreen(navController, navigator, setIsBottomBarVisible)
        }
        homeNavigation(navController, navigator, setIsBottomBarVisible) {
            homeDetailedScreen(navController, navigator, setIsBottomBarVisible)
        }
        generalNavigation(navController, navigator, setIsBottomBarVisible) {
            generalDetailedScreen(navController, navigator, setIsBottomBarVisible)
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    navigator: Navigator,
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 0.dp,
        content = {
            TopLevelDestination.entries.forEachIndexed { index, destination ->
                val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
                if (selected) selectedTab = index
                NavigationBarItem(
                    selected = selectedTab == index,
                    onClick = {
                        when (destination) {
                            TopLevelDestination.SETTINGS_SCREEN ->
                                navigator.navigateToSettings(navController)

                            TopLevelDestination.HOME_SCREEN ->
                                navigator.navigateToHome(navController)

                            TopLevelDestination.GENERAL_SCREEN ->
                                navigator.navigateToGeneral(navController)
                        }
                        selectedTab = index
                    },
                    label = {
                        Text(
                            text = destination.iconText,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    icon = {
                        val icon = if (selected) destination.selectedIcon
                        else destination.unselectedIcon
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = if (selected) Color.Green else Color.White,
                        )
                    }
                )
            }
        }
    )

}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false