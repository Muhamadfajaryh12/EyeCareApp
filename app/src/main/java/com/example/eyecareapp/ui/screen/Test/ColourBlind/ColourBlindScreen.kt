package com.example.eyecareapp.ui.screen.Test.ColourBlind

import ColourBlindContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.data.Data

@Composable
fun ColourBlindScreen (
    navigateToResult: (String) -> Unit,
    navigateBack : ()->Unit,
    viewModel: ColourBlindViewModel= viewModel(
        factory = ViewModelFactory.getInstance(LocalContext.current)
    )
) {
    var currentQuizIndex by remember { mutableStateOf(0) }
    if(currentQuizIndex < Data.data.size){
        ColourBlindContent(
            navigateToResult,
            quiz=Data.data[currentQuizIndex],
                onNextClick = {
                    currentQuizIndex++
                },
            navigateBack = navigateBack,
            viewModel = viewModel
            )
    }else{
        Text(text = "Done")
    }
}