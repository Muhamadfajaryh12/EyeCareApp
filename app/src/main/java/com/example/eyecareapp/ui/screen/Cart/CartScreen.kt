package com.example.eyecareapp.ui.screen.Cart

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.di.Injection
import com.example.eyecareapp.ui.components.content.CartContent

@Composable
fun CartScreen(
    viewModel: CartViewModel = viewModel(
         factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current),
        )
    ),
    navigateToDetail:(Int) -> Unit
) {
                CartContent(
                    viewModel = viewModel,
                    navigateToDetail = navigateToDetail
                )

}