package com.example.eyecareapp.ui.screen.Detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.di.Injection
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.content.DetailContent


@Composable
fun DetailScreen (
    navigateToPayment : () -> Unit,
    navigateBack:()->Unit,
    id:Int,
    viewModel:DetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    )
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let{
        uiState ->  when(uiState){
            is UiState.Loading -> {
                viewModel.getGlassById(id)
            }
            is UiState.Success -> {
                val data = uiState.data.glass
                val wishlist = uiState.data.wishlist
                DetailContent(
                    navigateToPayment = navigateToPayment,
                    navigateBack = navigateBack,
                    unChecked = { glass -> viewModel.deleteWishlist(glass) },
                    isChecked = { glass -> viewModel.addWishlist(glass)},
                    id = data.id,
                    title = data.title,
                    image = data.image,
                    type = data.type,
                    price = data.price,
                    checked = wishlist
                )
            }
            is UiState.Error -> {}
        }
    }
}