package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun ColourBlindContent(
    navigateToResult: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .clickable { /* Handle back action */ }
            )
            Text(
                text = "Hypermopia Or Hymopia Test",
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.hypermopiaorhypomiatest),
            contentDescription = "Hypermopia Or Hymopia Test ",
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(Color.White),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            modifier = Modifier
                .background(
                    color = Color(0xFF4682A9),
                    shape = RoundedCornerShape(5.dp)
                )
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(answerOptions) { option ->
                    AnswerOptionItem(option = option)
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = { navigateToResult() },
                modifier = Modifier
                    .width(300.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
            ) {
                Text(text = "Selesai")
            }
        }
    }
}

@Composable
fun AnswerOptionItem(option: Int) {
    Spacer(modifier = Modifier.padding(10.dp))
    Row(
        modifier = Modifier
            .widthIn(max = 350.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .background(Color.White)
            .padding(horizontal = 50.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Checkbox untuk customize
        var isChecked by remember { mutableStateOf(false) }

        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            modifier = Modifier.padding(start = 8.dp, top = 8.dp)
        )

        Spacer(modifier = Modifier.width(16.dp)) // Adjust the width as needed

        Image(
            painter = painterResource(id = option),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(5.dp))
        )
    }
}

val answerOptions = listOf(
    R.drawable.hypermopiaorhypomiatest,
    R.drawable.hypermopiaorhypomiatest,
    R.drawable.hypermopiaorhypomiatest,
    R.drawable.hypermopiaorhypomiatest
)

@Preview(showBackground = true)
@Composable
fun PreviewColourBlindTestScreen() {
    EyeCareAppTheme {
        ColourBlindContent(navigateToResult = {})
    }
}


