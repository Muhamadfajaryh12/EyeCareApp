package com.example.eyecareapp.ui.screen.Detail.Payment

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.content.PaymentContent
import com.example.eyecareapp.ui.screen.Payment.PaymentViewModel
import kotlinx.coroutines.launch
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun PaymentScreen (
    id:Int,
    ukuran:String,
    warna:String,
    viewModel: PaymentViewModel = viewModel(
        factory = ViewModelFactory.getInstance(LocalContext.current)
    ),
    navigateBack:()->Unit,
    navigateToCart:()->Unit
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    fun showSnackbar(message: String) {
        scope.launch {
            snackbarHostState.showSnackbar(
                message = message,
                duration = SnackbarDuration.Short
            )
        }
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { contentPadding ->
        viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { data ->
            when (data) {
                is UiState.Loading -> {
                    viewModel.getGlassById(id)
                }

                is UiState.Success -> {
                    PaymentContent(
                        id = id,
                        title = data.data.glass.title,
                        image = data.data.glass.image,
                        type = data.data.glass.type,
                        price = data.data.glass.price,
                        ukuran = ukuran,
                        warna = warna,
                        viewModel = viewModel,
                        navigateBack = navigateBack,
                        navigateToCart = navigateToCart,
                        showSnackBar = { message-> showSnackbar(message)},
                    )
                }

                is UiState.Error -> {}
            }
        }
    }
}