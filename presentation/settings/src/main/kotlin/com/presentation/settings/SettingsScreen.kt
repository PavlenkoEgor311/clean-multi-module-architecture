package com.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.navigation.api.INavigator

@Composable
fun SettingsScreen(
    navHostController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Settings",
            color = Color.Black,
        )
        Button(
            onClick = {
                navigator.navigateToSettingsDetailed(navHostController)
            }
        ) {
            Text(
                text = "Navigate to Settings Detailed",
                color = Color.Black,
            )
        }
    }
}