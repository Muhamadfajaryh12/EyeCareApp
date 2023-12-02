package com.example.eyecareapp.ui.screen.Register

import androidx.compose.runtime.Composable
import com.example.eyecareapp.ui.components.content.RegisterContent

@Composable
fun RegisterScreen (
    navigateToLogin : () -> Unit
){
    RegisterContent(navigateToLogin)
}