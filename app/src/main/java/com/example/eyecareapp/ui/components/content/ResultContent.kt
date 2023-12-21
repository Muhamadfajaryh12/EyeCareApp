package com.example.eyecareapp.ui.components.content

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.data.GlassData
import com.example.eyecareapp.ui.components.common.GlassesCard
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun ResultContent(
    navigateToDetail : (Int) -> Unit,
    title : String,
    navigateBack: ()->Unit
) {
    Column (
        modifier = Modifier
            .background(Color(0xFF4682A9))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) { Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription ="Back",
            modifier = Modifier
                .clickable { navigateBack() }
                .padding( end = 5.dp)
        )
        Text(
            text = "Result",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Test Result",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(top=10.dp)
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
                Text(text = "Glasses List",
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
                                    .clickable { navigateToDetail(glass.id) }
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
            navigateToDetail = {},
            title = "",
            navigateBack = {}
        )
    }
}