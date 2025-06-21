package com.example.newapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newapp.ui.theme.*
import com.google.android.gms.location.LocationServices
import com.google.firebase.FirebaseApp
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
//import com.example.newapp.LocationScreen


// Define your screen routes
sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Location : Screen("location_screen")
    object SignIn : Screen("sign_in_screen")
    object LoginPass : Screen("login_pass_screen")
    object CreateAccount : Screen("create_account_screen")
    object About : Screen("about_screen")
    object ForgotPassword : Screen("forgot_password_screen")
    object PasswordReset : Screen("password_reset_screen")

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
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
        composable(Screen.Location.route) {
            LocationScreen(navController = navController)
        }

        // Sign In Screen
        composable(Screen.SignIn.route) {
            SignInScreen(navController = navController)
        }

        // LoginPass Screen with email passed as argument
        composable(
            route = Screen.LoginPass.route + "?email={email}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) { backStackEntry ->
            val email = backStackEntry.arguments?.getString("email") ?: ""
            LoginPass(navController = navController, email = email)
        }

        // Create Account
        composable(Screen.CreateAccount.route) {
            CreateAccount(navController = navController)
        }

        // About
        composable(Screen.About.route) {
            About(navController = navController)
        }

        // Forgot Password
        composable(Screen.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }

        // Password Reset
        composable(Screen.PasswordReset.route) {
            PasswordReset(navController = navController)
        }
    }
}
