package com.example.eyecareapp.ui.screen.Profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.di.Injection
import com.example.eyecareapp.ui.components.content.ProfileContent

@Composable
fun ProfileScreen (
    navigateToChangeProfile : () -> Unit,
    viewModel: ProfileViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current)
        )
    ),
    navigateToLogin:()->Unit
) {
    ProfileContent(
        navigateToChangeProfile,
        logout = viewModel::logout,
        navigateToLogin = navigateToLogin
    )
}