package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun TestContent (
    navigateToColourBlindTest : () -> Unit,
    navigateToHypomiaTest : () -> Unit
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(id = R.string.test),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
        )
        Text(
            text = stringResource(id = R.string.choose_test),
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = { navigateToColourBlindTest()},
            modifier = Modifier
                .width(300.dp)
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF4682A9),
                contentColor = Color.White
            )
        ) {
            Text(
                text = stringResource(id = R.string.test_colourblind),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun prevTestContent(){
    EyeCareAppTheme {
        TestContent(
            navigateToColourBlindTest = {},
            navigateToHypomiaTest = {}
        )
    }
}