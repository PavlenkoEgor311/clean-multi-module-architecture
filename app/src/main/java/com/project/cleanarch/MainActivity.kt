package com.project.cleanarch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.navigation.impl.NavHost
import com.project.cleanarch.ui.theme.CleanarchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanarchTheme {
                NavHost(rememberNavController())
            }
        }
    }
}