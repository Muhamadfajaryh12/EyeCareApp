package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.data.GlassData
import com.example.eyecareapp.ui.components.common.OrderCard
import com.example.eyecareapp.ui.components.common.WishlistCard
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun CartContent (
    wishItem:List<Glass>,
    navigateToDetail:(Int) -> Unit
) {
    Column (
        modifier = Modifier
            .padding(10.dp)
    ){
        Text(
            text = "Order Cart",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OrderCard()
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = "Wishlist",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        if(!wishItem.isNullOrEmpty()){
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally
            ){
                items(wishItem){ data ->
                    WishlistCard(
                        title = data.title,
                        image = data.image,
                        price = data.price,
                        navigateToDetail = navigateToDetail,
                        id = data.id
                    )
                }
            }
        }
        else{
            Text(text = "There is no wish list yet")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevCartContent () {
    EyeCareAppTheme {
        CartContent(
            wishItem = GlassData.glass,
            navigateToDetail = {}
        )
    }
}