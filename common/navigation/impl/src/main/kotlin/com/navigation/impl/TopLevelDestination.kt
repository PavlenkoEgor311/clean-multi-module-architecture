package com.navigation.impl

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconText: String,
) {
    GENERAL_SCREEN(
        selectedIcon = Icons.Default.Add,
        unselectedIcon = Icons.Default.Add,
        iconText = "General",
    ),
    HOME_SCREEN(
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        iconText = "Home",
    ),
    SETTINGS_SCREEN(
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        iconText = "Settings",
    ),
}