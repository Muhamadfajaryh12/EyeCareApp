package com.example.eyecareapp.ui.screen.Detail.Payment

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.di.Injection
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.content.PaymentContent
import com.example.eyecareapp.ui.screen.Payment.PaymentViewModel

@Composable
fun PaymentScreen (
    id:Int,
    ukuran:String,
    warna:String,
    viewModel: PaymentViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current),
        )
    ),
    navigateBack:()->Unit,
    navigateToCart:()->Unit
) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let {
        data -> when(data){
            is UiState.Loading->{
                viewModel.getGlassById(id)
            }
            is UiState.Success->{
                PaymentContent(
                    id = id,
                    title = data.data.glass.title,
                    image = data.data.glass.image,
                    type=data.data.glass.type,
                    price = data.data.glass.price,
                    ukuran = ukuran,
                    warna = warna,
                    viewModel = viewModel,
                    navigateBack = navigateBack,
                    navigateToCart = navigateToCart
                )
            }
            is UiState.Error ->{}
        }
    }
}