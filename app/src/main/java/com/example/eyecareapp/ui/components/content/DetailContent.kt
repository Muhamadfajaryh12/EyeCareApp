package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun DetailContent() {
    Column {
        Text(
            text = "Glasses",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = "Rp.1.000.000",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        )
        Text(
            text = "Pilih Warna",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Text(
            text = "Pilih Ukuran",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}