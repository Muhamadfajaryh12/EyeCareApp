package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun PaymentContent () {
    Column {
        Text(text = "Pilih Pembayaran",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}