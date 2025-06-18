package com.example.newapp.ui.theme

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newapp.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginPass(navController: NavHostController, email: String) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var loading by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 27.dp, vertical = 123.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign in",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(4.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (passwordVisible) "Hide" else "Show"
                Text(
                    text = icon,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable { passwordVisible = !passwordVisible }
                )
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                loading = true
                val auth = FirebaseAuth.getInstance()
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        loading = false
                        if (task.isSuccessful) {
                            Toast.makeText(context, "User Registered Successfully", Toast.LENGTH_SHORT).show()
                            navController.navigate(Screen.About.route)
                        } else {
                            // If already registered, sign in
                            auth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener { signInTask ->
                                    if (signInTask.isSuccessful) {
                                        Toast.makeText(context, "Signed In Successfully", Toast.LENGTH_SHORT).show()
                                        navController.navigate(Screen.About.route)
                                    } else {
                                        errorMessage = signInTask.exception?.localizedMessage
                                    }
                                }
                        }
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E6CEF)),
            shape = RoundedCornerShape(100.dp)
        ) {
            Text("Continue", fontSize = 16.sp)
        }

        if (loading) {
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator()
        }

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = errorMessage!!, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text("Forgot Password? ")
            Text(
                "Reset",
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.ForgotPassword.route)
                }
            )
        }
    }
}
