package com.example.newapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import com.example.newapp.Screen  // Make sure this points to your sealed Screen class

@Composable
fun SplashScreen(navController: NavHostController) {
    // Navigate to SignIn screen after 2 seconds
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(Screen.SignIn.route) {
            popUpTo(Screen.Splash.route) { inclusive = true } // removes Splash from backstack
        }
    }

    // UI
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF9466F6)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Clot",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontFamily = FontFamily.SansSerif
        )
    }
}
