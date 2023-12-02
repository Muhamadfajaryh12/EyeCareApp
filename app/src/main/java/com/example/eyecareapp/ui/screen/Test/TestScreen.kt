package com.example.eyecareapp.ui.screen.Test

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eyecareapp.ui.components.content.TestContent
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun TestScreen () {
    Box(
        modifier = Modifier.padding(10.dp)){
        TestContent()
    }
}

@Preview(showBackground = true)
@Composable
fun prevTestScreen () {
    EyeCareAppTheme {
        TestScreen()
    }
}