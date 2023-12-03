package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.data.GlassData
import com.example.eyecareapp.ui.components.common.GlassesCard
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun ResultContent(
    navigateToDetail : () -> Unit
) {
    Column (
        modifier = Modifier.background(Color(0xFF4682A9)).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row {
            Text(
                text = "Result",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
        Card  (
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .padding(10.dp)
                .width(300.dp)
        ){
            Column(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Test Result",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.sunglasses),
                    contentDescription ="" ,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                    )
                Text(
                    text = "Rabun Dekat",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = " +0.50",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }
        }
        Card (
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(10.dp,10.dp)
        ){
            Column(modifier = Modifier.padding(5.dp)){
                Text(text = "Recommendation",
                    style= TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(130.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxSize()
                    ) {
                        items(GlassData.glass, key = { it.id }) { glass ->
                            GlassesCard(title = glass.title, image = glass.image,
                                price = glass.price, type = glass.type,
                                modifier = Modifier
                                    .clickable { navigateToDetail() }
                            )
                        }
                    }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun prevResultContent(){
    EyeCareAppTheme {
        ResultContent(
            navigateToDetail = {}
        )
    }
}