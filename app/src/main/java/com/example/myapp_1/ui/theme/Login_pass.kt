package com.example.myapp_1.ui.theme

//import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginPass() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 27.dp, vertical = 123.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sign in",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Password Field with visibility toggle
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
//            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
//            trailingIcon = {
//                val icon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
//                val description = if (passwordVisible) "Hide password" else "Show password"
//
//                IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                    Icon(imageVector = icon, contentDescription = description)
//                }
//            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Continue Button
        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E6CEF)),
            shape = RoundedCornerShape(100.dp)
        ) {
            Text("Continue", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom Text
        Row {
            Text("Forgot Password ")
            Text(
                "Reset",
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
    }
}
