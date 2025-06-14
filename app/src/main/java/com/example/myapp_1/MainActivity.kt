package com.example.myapp_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapp_1.ui.theme.About
import com.example.myapp_1.ui.theme.CreateAccount
import com.example.myapp_1.ui.theme.ForgotPassword
import com.example.myapp_1.ui.theme.LoginPass
import com.example.myapp_1.ui.theme.Myapp_1Theme
import com.example.myapp_1.ui.theme.PasswordReset
import com.example.myapp_1.ui.theme.SignInScreen
//import com.example.myapp_1.ui.theme.SocialLoginButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Myapp_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //ClotSplashScreen()
                    //SignInScreen()
                   // LoginPass()
                  // CreateAccount()
               // ForgotPassword()
                    //PasswordReset()
                   About()
                }
            }
        }
    }
}


