package com.example.eyecareapp.ui.components.content

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eyecareapp.MainActivity
import com.example.eyecareapp.R
import kotlinx.coroutines.delay

class SplashContent : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White // Set your desired background color
            ) {
                SplashContent(onTimeout = {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                })
            }
        }
    }
}

@Composable
fun SplashContent(onTimeout: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(3000)
        onTimeout.invoke()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Box at the top of the screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // Set the desired height
                .align(Alignment.TopCenter)
                .background(color = Color(0xFF4682A9)) // Set the desired color
        )

        // Content in the middle of the screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp), // Reduce padding at the bottom for the aquarium element
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.glasses),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF4682A9))
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Eye Care",
                color = Color.Black
            )
        }

        // Aquarium element at the bottom of the screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp) // Height of the aquarium water
                .align(Alignment.BottomCenter)
                .background(color = Color(0xFF4682A9)) // Color of the aquarium water
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashContent(onTimeout = {})
}




