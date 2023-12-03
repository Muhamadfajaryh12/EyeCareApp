package com.example.eyecareapp.ui.screen.Test.Hypomia

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.eyecareapp.ui.components.content.HypermopiaOrHymopiatestContent

@Composable
fun HypomiaScreen(
     navigateToResult : () -> Unit
) {
    HypermopiaOrHymopiatestContent(
        navigateToResult
    )
}

@Preview(showBackground = true)
@Composable
fun prevHypomiaScreen(){
    HypomiaScreen(
        navigateToResult = {}
    )
}