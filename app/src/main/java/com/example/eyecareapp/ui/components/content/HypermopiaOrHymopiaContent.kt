package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.theme.EyeCareAppTheme


@Composable
fun HypermopiaOrHymopiatestContent(
    navigateToResult : () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                    text = "Vision Test",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(id = R.drawable.hypermopiaorhypomiatest), // Ganti dengan gambar yang sesuai
                contentDescription = "Hypermopia / Hymopiatest Image",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = Color(0xFF4682A9),
                        shape = RoundedCornerShape(5.dp)
                    )
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ){
                    AnswerOptionItem(
                        option1 = "Option 1",
                        option2 = "Option 2",
                        option3 = "Option 3",
                        option4 = "Option 4"
                    )
                    Button(onClick = { navigateToResult()},
                        modifier=Modifier
                            .width(300.dp)
                            .clip(shape= RoundedCornerShape(5.dp))
                    ) {
                        Text(text = "Selesai")
                    }
                }
            }
        }
    }
}

@Composable
fun AnswerOptionItem(option1: String, option2: String, option3: String, option4: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .background(
                    color = Color(0xFF4682A9),
                    shape = RoundedCornerShape(5.dp)
                )
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .padding(8.dp)
            ) {// bisa diubah pakai lazygrid
                Image(
                    painter = painterResource(id = R.drawable.hypermopiaorhypomiatest), // Ganti dengan gambar yang sesuai
                    contentDescription = "Option 1",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hypermopiaorhypomiatest), // Ganti dengan gambar yang sesuai
                    contentDescription = "Option 2",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hypermopiaorhypomiatest), // Ganti dengan gambar yang sesuai
                    contentDescription = "Option 3",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hypermopiaorhypomiatest), // Ganti dengan gambar yang sesuai
                    contentDescription = "Option 4",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHypermopiaorHymopiatestScreen() {
    EyeCareAppTheme {
        HypermopiaOrHymopiatestContent(
             navigateToResult = {}
        )
    }
}
