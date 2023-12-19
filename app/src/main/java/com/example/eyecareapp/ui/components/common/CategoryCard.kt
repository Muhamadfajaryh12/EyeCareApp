package com.example.eyecareapp.ui.components.common

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.eyecareapp.ui.theme.EyeCareAppTheme

@Composable
fun CategoryCard(
   title:String,
   photo:Int,
   category:(String)->Unit
)
{

   Column (
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
         .height(80.dp)
         .clickable { category(title) }
   ){
      Box(modifier = Modifier.width(60.dp).height(60.dp).clip(CircleShape).border(1.dp, Color.Gray,
         CircleShape)){
         AsyncImage(
            model = photo,
            contentDescription = title,
            modifier= Modifier
               .fillMaxSize()
               .padding(10.dp)
               .clip(CircleShape)
         )
      }
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
         photo = 1,
         category = {}
      )
   }
}