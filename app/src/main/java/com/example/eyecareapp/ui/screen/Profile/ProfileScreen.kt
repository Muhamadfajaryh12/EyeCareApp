package com.example.eyecareapp.ui.screen.Profile

import androidx.compose.runtime.Composable
import com.example.eyecareapp.ui.components.content.ProfileContent

@Composable
fun ProfileScreen (
    navigateToChangeProfile : () -> Unit
) {
    ProfileContent( navigateToChangeProfile)
}