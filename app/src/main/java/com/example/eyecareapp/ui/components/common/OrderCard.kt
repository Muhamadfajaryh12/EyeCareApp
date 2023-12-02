package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun OrderCard() {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .width(300.dp)
            .height(60.dp)
            .clip(shape = RoundedCornerShape(10.dp))
    ){
        Row {
            AsyncImage(
                model = "https://s1.bukalapak.com/img/1678161611/w-1000/Frame_Kacamata_Bulat_EIDIYA_BLACK_E6107_C22_12M17.jpg",
                contentDescription = null,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(60.dp)
            ) {
                Text(
                    text = "Glasses",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                )
                Row {
                    Text(
                        text = "Status : ",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(2.dp)
                    )
                    Box(modifier = Modifier
                        .background(Color(0xFFFF9900))
                        .clip(shape = RoundedCornerShape(5.dp))
                    ){
                        Text(
                            text = "Dalam pengiriman",
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp,
                                color = Color.White,
                            ),
                            modifier = Modifier
                                .padding(2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun prevOrderCard () {
    EyeCareAppTheme {
        OrderCard()
    }
}