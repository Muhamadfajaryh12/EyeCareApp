package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun WishlistCard () {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .width(300.dp)
    ){
        Row {
            AsyncImage(
                model = "https://s1.bukalapak.com/img/1678161611/w-1000/Frame_Kacamata_Bulat_EIDIYA_BLACK_E6107_C22_12M17.jpg",
                contentDescription = null,
                modifier = Modifier
                    .width(60.dp)
                    .height(40.dp)
            )
            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(40.dp)
            ) {
                Text(
                    text = "Glasses",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp
                    )
                )
                    Text(
                        text = "Harga : Rp.1.000.000",
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 10.sp
                        )
                    )
            }
        }
    }
}