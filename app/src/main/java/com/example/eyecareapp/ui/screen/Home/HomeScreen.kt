package com.example.eyecareapp.ui.screen.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eyecareapp.ui.components.content.HomeContent
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun HomeScreen (
navigateToDetail:(Int) -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HomeContent(
            navigateToDetail = navigateToDetail
                )
    }

}

@Preview (showBackground = true)
@Composable
fun prevHomeScreen(){
    EyeCareAppTheme {
        HomeScreen(
            navigateToDetail = {}
        )
    }
}