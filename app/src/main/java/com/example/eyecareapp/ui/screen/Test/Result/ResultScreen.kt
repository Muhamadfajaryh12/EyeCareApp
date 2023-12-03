package com.example.eyecareapp.ui.screen.Test.Result

import androidx.compose.runtime.Composable
import com.example.eyecareapp.ui.components.content.ResultContent

@Composable
fun ResultScreen (
    navigateToDetail : () -> Unit
) {
    ResultContent(navigateToDetail)

}