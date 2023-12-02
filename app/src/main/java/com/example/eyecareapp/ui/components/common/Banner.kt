package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun Banner (

){
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(120.dp),
        colors = CardDefaults
            .cardColors(
            containerColor = Color(0xFF4682A9)
            ),
        shape = RoundedCornerShape(10.dp)
    ){
        Row (
            modifier = Modifier
                .padding(5.dp)
        )
        {
            Column {
                Text(
                    text = "Temukan Kacamata",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
                Text(
                    text = "Sesuai Selera dan Kebutuhanmu",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                )
            }
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription ="",
                modifier = Modifier
                    .width(100.dp)
                    .height(130.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun prevBanner(){
    EyeCareAppTheme {
        Banner()
    }
}