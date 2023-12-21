package com.example.eyecareapp.ui.screen.Detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.content.DetailContent
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen (
    navigateToPayment : (Int,String,String) -> Unit,
    navigateBack:()->Unit,
    id:Int,
    viewModel: DetailViewModel = viewModel(
        factory = ViewModelFactory.getInstance(LocalContext.current)

    )
){
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
        modifier = Modifier.background(Color.White)
    ) { contentPadding ->
        viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
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
                        isChecked = { glass -> viewModel.addWishlist(glass) },
                        id = data.id,
                        title = data.title,
                        image = data.image,
                        type = data.type,
                        price = data.price,
                        checked = wishlist,
                        listUkuran = data.listUkuran,
                        listWarna = data.listWarna,
                        description = data.description,
                        showSnackbar = {message -> showSnackbar(message)}
                    )
                }

                is UiState.Error -> {}
            }
        }
    }
}