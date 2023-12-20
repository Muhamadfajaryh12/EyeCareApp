package com.example.eyecareapp.ui.screen.Cart.Detail

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.di.Injection
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.content.DetailOrderContent

@Composable
fun  OrderDetail (
    viewModel: OrderDetailViewModel  = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(LocalContext.current),
        )
    ),
    id:Int,
    navigateBack:()->Unit
){
    viewModel.uiState.collectAsState().value.let {
        uiState -> when(uiState){
            is UiState.Loading->{
                CircularProgressIndicator()
                viewModel.getOrderById(id)
            }
            is UiState.Success->{
                val data = uiState.data
                DetailOrderContent(
                    title = data.title,
                    image = data.image,
                    type =  data.type,
                    price = data.price,
                    ukuran = data.ukuran,
                    warna = data.warna,
                    address = data.address,
                    account = data.account,
                    payment = data.payment,
                    status = data.status,
                    navigateBack = navigateBack
                )
            }
            is UiState.Error->{}
        }
    }
}