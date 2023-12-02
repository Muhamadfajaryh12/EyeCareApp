package com.example.eyecareapp.ui.screen.Detail

import androidx.compose.runtime.Composable
import com.example.eyecareapp.ui.components.content.DetailContent


@Composable
fun DetailScreen (
    navigateToPayment : () -> Unit
){
    DetailContent(navigateToPayment)
}