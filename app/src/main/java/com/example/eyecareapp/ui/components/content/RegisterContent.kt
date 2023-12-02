package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.ui.components.common.InputWithIcon

@Composable
fun RegisterContent (
    navigateToLogin : () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Text(
            text = "REGISTER",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputWithIcon(
            icon = Icons.Default.Email ,
            placeholder = "Masukkan Email Anda",
            label = "Email")
        Spacer(modifier = Modifier.padding(10.dp))
        InputWithIcon(
            icon = Icons.Default.Person ,
            placeholder = "Masukkan Username Anda",
            label = "Username")
        Spacer(modifier = Modifier.padding(10.dp))
        InputWithIcon(
            icon = Icons.Default.Lock ,
            placeholder = "Masukkan Password Anda",
            label = "Password")
        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {},
            modifier= Modifier
                .width(300.dp),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Sign Up"
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row {
            Text(
                text = "Anda sudah memiliki akun ?",
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
            Text(
                text = " Login",
                style = TextStyle(
                    color = Color(0xFF000AFF),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .clickable { navigateToLogin() }
            )
        }
    }
}