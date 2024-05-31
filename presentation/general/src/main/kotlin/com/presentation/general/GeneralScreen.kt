package com.presentation.general

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.navigation.api.INavigator

@Composable
fun GeneralScreen(
    navHostController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
) {
    LaunchedEffect(Unit) {
        setIsBottomBarVisible(true)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "General",
            color = Color.Black,
        )
        Button(
            onClick = {
                navigator.navigateToGeneralDetailed(navHostController)
            }
        ) {
            Text(
                text = "Navigate to General Detailed",
                color = Color.Black,
            )
        }
    }
}
