package com.example.eyecareapp.ui.screen.Profile

import androidx.compose.runtime.Composable
import com.example.eyecareapp.ui.components.content.ChangeProfileContent

@Composable
fun ChangeProfileScreen (
    navigateBack : () -> Unit
){
    ChangeProfileContent(navigateBack)
}