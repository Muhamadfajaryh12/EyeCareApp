package com.example.eyecareapp.ui.screen.Test.Result

import androidx.compose.runtime.Composable
import com.example.eyecareapp.ui.components.content.ResultContent

@Composable
fun ResultScreen (
    id:String,
    navigateBack:()->Unit,
    navigateToDetail : (Int) -> Unit
) {

    ResultContent(navigateToDetail, title = id, navigateBack = navigateBack)

}