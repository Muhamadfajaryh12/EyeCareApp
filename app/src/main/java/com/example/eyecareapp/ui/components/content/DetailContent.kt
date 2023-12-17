package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.ui.theme.EyeCareAppTheme


@Composable
fun DetailContent(
    navigateToPayment : () -> Unit,
    navigateBack:()-> Unit,
    checked:Boolean,
    unChecked:(Glass)->Unit,
    isChecked:(Glass)->Unit,
    id:Int,
    title:String,
    image:String,
    type:String,
    price:String,
    showSnackbar:(String)->Unit
) {
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Row(
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
                text = "Detail Glasses",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
        }
        AsyncImage(
            model = image,
            contentDescription = title,
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Column() {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = price,
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
           LazyRow(

           ){
               items(optionWarnaDummy){
                   options ->
                   boxSelected(Option = options)
               }
           }
            Text(
                text = "Pilih Ukuran",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            LazyRow(

            ){
                items(optionUkuranDummy){
                        options ->
                    boxSelected(Option = options)
                }
            }
            Text(
                text = "Deskripsi Produk",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enimad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in  voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
                        " Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                style = TextStyle(
                    fontSize = 10.sp,
                    textAlign = TextAlign.Justify
                )
            )
            Text(
                text = "Informasi",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Row {
                Text(
                    text = "Ongkir Reguler 8 rb - 14 rb", style = TextStyle(
                        fontSize = 10.sp,
                    )
                )
            }
            Text(
                text = "Estimasi tiba 3 hari",
                style = TextStyle(
                    fontSize = 10.sp,
                )
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            if(checked){
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription ="Wishlist",
                    modifier = Modifier
                        .clickable {
                            unChecked(Glass(id,title,image,price,type))
                            showSnackbar("Remove glasses from wishlist ")
                        }
                        .size(30.dp)
                )
            }
            else{
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Wishlist",
                    modifier = Modifier
                        .clickable {
                            isChecked(Glass(id,title,image,price,type))
                            showSnackbar("Added glasses to wishlist")
                        }
                        .size(30.dp)
                )

            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = { navigateToPayment() },
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = "Buy", style = TextStyle(fontWeight = FontWeight.Bold, color = Color.White))
        }
    }
}

@Composable
fun boxSelected (Option : String){
    Box(modifier = Modifier
        .padding(5.dp)
        .border(width = 1.dp, color = Color.Black)
        .clip(shape = RoundedCornerShape(5.dp))){
        Text(
            text=Option,
            style= TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .padding(5.dp)
        )
    }
}
val optionWarnaDummy = listOf("Biru","Merah","Hitam")
val optionUkuranDummy = listOf("-0,50","-0,75","-1.00")
@Preview (showBackground = true)
@Composable
fun prevDetailContent (){
    EyeCareAppTheme {
        DetailContent(
            navigateToPayment ={},
            navigateBack = {},
            checked = false,
            unChecked = {},
            isChecked = {},
            id = 1,
            title = "test",
            image="test",
            type="test",
            price="test",
            showSnackbar = {}
        )
    }
}