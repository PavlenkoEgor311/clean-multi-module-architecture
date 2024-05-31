package com.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.navigation.api.INavigator

@Composable
fun AuthScreen(
    navHostController: NavHostController,
    navigator: INavigator,
    setIsBottomBarVisible: (Boolean) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "AuthScreen",
                color = Color.Black,
            )
            Button(onClick = { navigator.navigateToGeneral(navHostController) }) {
                Text(
                    text = "Is Auth User => navigate to home",
                    color = Color.Black,
                )
            }
        }
    }
}