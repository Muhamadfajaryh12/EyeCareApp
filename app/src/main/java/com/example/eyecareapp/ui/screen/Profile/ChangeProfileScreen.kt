package com.example.eyecareapp.ui.screen.Profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.ui.components.content.ChangeProfileContent

@Composable
fun ChangeProfileScreen (
    navigateBack : () -> Unit,
    viewModel: ProfileViewModel= viewModel(
        factory = ViewModelFactory.getInstance(LocalContext.current)
    ),

){
    ChangeProfileContent(
        navigateBack,
        viewModel= viewModel
    )
}