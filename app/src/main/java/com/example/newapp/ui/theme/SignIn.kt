package com.example.newapp.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.newapp.R
import com.example.newapp.Screen

@Composable
fun SignInScreen(navController: NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue("")) }

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

        // Email address
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email Address") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(4.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Continue Button
        Button(
            onClick = {
                // Send email to LoginPass screen
                navController.navigate(Screen.LoginPass.route + "?email=${email.text}")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E6CEF)),
            shape = RoundedCornerShape(100.dp)
        ) {
            Text("Continue", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom text
        Row {
            Text("Don't have an Account? ")
            Text(
                "Create One",
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                modifier = Modifier.clickable {
                    navController.navigate(Screen.CreateAccount.route)
                }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Apple Button
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4F4F4)),
            shape = RoundedCornerShape(100.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "Apple Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Continue With Apple", fontSize = 16.sp, color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Google Button
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4F4F4)),
            shape = RoundedCornerShape(100.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Continue With Google", fontSize = 16.sp, color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Facebook Button
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF4F4F4)),
            shape = RoundedCornerShape(100.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook Icon",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Continue With Facebook", fontSize = 16.sp, color = Color.Black)
                }
            }
        }
    }
}
