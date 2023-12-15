package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun WishlistCard (
    title : String,
    image : String,
    price : String,
    id:Int,
    navigateToDetail:(Int) -> Unit
) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .width(300.dp)
            .height(60.dp)
            .clickable {
                navigateToDetail(id)
            }
    ){
        Row {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
            )
            Column (
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(60.dp).padding(10.dp)
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp
                    )
                )
                    Text(
                        text = price,
                        style = TextStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp
                        )
                    )
            }
        }
    }
}

@Preview
@Composable
fun prevWishlistCard(){
    EyeCareAppTheme {
        WishlistCard(
            title = "test", image = "test", price = "test", id = 1, navigateToDetail = {}
        )
    }
}