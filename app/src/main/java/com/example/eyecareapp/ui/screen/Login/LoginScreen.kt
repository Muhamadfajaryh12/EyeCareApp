package com.example.eyecareapp.ui.screen.Login

import androidx.compose.runtime.Composable
import com.example.eyecareapp.ui.components.content.LoginContent

@Composable
fun LoginScreen (
    navigateToRegister : () -> Unit
) {
    LoginContent(
        navigateToRegister
    )
}