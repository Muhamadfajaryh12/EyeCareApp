package com.example.eyecareapp.ui.screen.Login

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.ui.components.content.LoginContent
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun LoginScreen (
    navigateToRegister: () -> Unit,
    viewModel: LoginViewModel = viewModel(
        factory = ViewModelFactory.getInstance(LocalContext.current)
    ),
    viewModelFactory: () -> Unit = { ViewModelFactory.resetInstance() },
    navigateToHome:() -> Unit,
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
        LoginContent(
            navigateToRegister,
            viewModel = viewModel,
            navigateToHome = navigateToHome,
            showSnackBar = { message-> showSnackbar(message)},
            factory = viewModelFactory
        )
    }
}
