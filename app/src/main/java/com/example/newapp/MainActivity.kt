package com.example.newapp

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newapp.ui.theme.About
import com.example.newapp.ui.theme.SplashScreen
import com.example.newapp.ui.theme.NewAppTheme
import com.example.newapp.ui.theme.SignInScreen
import kotlinx.coroutines.delay
import com.example.newapp.ui.theme.LoginPass
import com.example.newapp.ui.theme.CreateAccount
import com.example.newapp.ui.theme.ForgotPassword
import com.example.newapp.ui.theme.About
import com.example.newapp.ui.theme.PasswordReset
// Define screen routes
sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object SignIn : Screen("sign_in_screen")
    object LoginPass : Screen("login_pass_screen")
    object CreateAccount : Screen("Create_Account_screen")
    object About : Screen("About_screen")
    object ForgotPassword : Screen("forgot_password_screen")
    object PasswordReset : Screen("Password_Reset_screen")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // Splash Screen
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        // Sign In Screen
        composable(Screen.SignIn.route) {
            SignInScreen(navController = navController)
        }
        //login pass screen
        composable(Screen.LoginPass.route) {
            LoginPass(navController = navController)
        }
        //create account screen
        composable(Screen.CreateAccount.route) {
            CreateAccount(navController = navController)
        }
        composable(Screen.About.route) {
            About(navController = navController)
        }
        composable(Screen.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }
        composable(Screen.PasswordReset.route) {
            PasswordReset(navController = navController)
        }
    }
}