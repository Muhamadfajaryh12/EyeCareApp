package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun CategoryCard(
   title:String,
   photo:String
)
{
   Column (
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
         .height(80.dp)
   ){
      AsyncImage(
         model = photo,
         contentDescription = title,
         modifier= Modifier
            .size(60.dp)
            .clip(CircleShape)
      )
      Text(
         text = title,
         style = TextStyle(
            fontSize = 10.sp
         )
      )
   }
}

@Preview
@Composable
fun prevCategoryCard(){
   EyeCareAppTheme {
      CategoryCard(
         title = "Hypomia",
         photo = "https://s1.bukalapak.com/img/1678161611/w-1000/Frame_Kacamata_Bulat_EIDIYA_BLACK_E6107_C22_12M17.jpg")
   }
}