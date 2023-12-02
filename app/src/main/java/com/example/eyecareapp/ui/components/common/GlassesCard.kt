package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.eyecareapp.ui.theme.EyeCareAppTheme


@Composable
fun GlassesCard (
        title:String,
        image:String,
        price:String,
        type:String,
        modifier: Modifier
){
        Card (
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
                    modifier = modifier
                        .width(130.dp)
                        .height(150.dp),
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
        )
        {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ){
                       AsyncImage(
                           model = image,
                           contentDescription = title,
                           modifier = Modifier
                                    .width(130.dp)
                                    .height(100.dp))

                        Text(text = title,
                            style = TextStyle(
                                fontSize = 10.sp,
                            )
                        )
                        Text(text = type,
                            style = TextStyle(
                                fontSize = 10.sp,
                                color = Color.Gray,
                                ))
                        Text(text = price,
                            style = TextStyle(
                                fontSize = 10.sp
                            ))
                }
        }
}

@Preview
@Composable
fun prevGlassesCard(){
    EyeCareAppTheme {
        GlassesCard(title = "test", image = "test", price ="Rp.1.000.000" , type = "test", modifier = Modifier)
    }
}


