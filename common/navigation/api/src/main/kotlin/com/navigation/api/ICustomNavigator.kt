package com.navigation.api

import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

interface INavigator {
    fun navigateToAuth(
        navController: NavHostController,
        modifier: Modifier = Modifier
    )

    fun navigateToSettings(
        navController: NavHostController,
        modifier: Modifier = Modifier,
    )

    fun navigateToSettingsDetailed(
        navController: NavHostController,
        modifier: Modifier = Modifier,
    )

    fun navigateToHome(
        navController: NavHostController,
        modifier: Modifier = Modifier,
    )

    fun navigateToHomeDetailed(
        navController: NavHostController,
        modifier: Modifier = Modifier,
    )

    fun navigateToGeneral(
        navController: NavHostController,
        modifier: Modifier = Modifier,
    )

    fun navigateToGeneralDetailed(
        navController: NavHostController,
        modifier: Modifier = Modifier,
    )
}