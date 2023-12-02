package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.ui.components.common.OrderCard
import com.example.eyecareapp.ui.components.common.WishlistCard
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun CartContent () {
    Column (
        modifier = Modifier
            .padding(10.dp)
    ){
        Text(
            text = "Keranjang Pesanan",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OrderCard()
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = "Wishlist",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        WishlistCard()
    }
}

@Preview(showBackground = true)
@Composable
fun prevCartContent () {
    EyeCareAppTheme {
        CartContent()
    }
}