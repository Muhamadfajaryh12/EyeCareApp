package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.eyecareapp.data.Glass
import com.example.eyecareapp.data.Ukuran
import com.example.eyecareapp.data.Warna


@Composable
fun DetailContent(
    navigateToPayment : (Int,String,String) -> Unit,
    navigateBack:()-> Unit,
    checked:Boolean,
    unChecked:(Glass)->Unit,
    isChecked:(Glass)->Unit,
    id:Int,
    title:String,
    image:String,
    type:String,
    price:String,
    description:String,
    listUkuran:List<Ukuran>,
    listWarna:List<Warna>,
    showSnackbar:(String)->Unit
) {
    var selectedWarna by remember { mutableStateOf<Warna?>(null) }
    var selectedUkuran by remember { mutableStateOf<Ukuran?>(null) }
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
        .background(Color.White),
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
                text = "Choose Color",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
           LazyRow(

           ){
               items(listWarna){
                   options ->
                   boxSelected(Option = options.warna,
                   isSelected = options == selectedWarna,
                   onClick = {   selectedWarna = if(selectedWarna == options) null else options}
                   )
               }
           }
            Text(
                text = "Choose Size",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            LazyRow(

            ){
                items(listUkuran){
                        options ->
                    boxSelected(
                        Option = options.ukuran,
                        isSelected = options == selectedUkuran,
                        onClick = {  selectedUkuran = if(selectedUkuran == options) null else options}
                    )
                }
            }
            Text(
                text = "Product Description",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Text(
                text = description,
                style = TextStyle(
                    fontSize = 10.sp,
                    textAlign = TextAlign.Justify
                )
            )
            Text(
                text = "Information",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Row {
                Text(
                    text = "Regular Delivery Fee IDR 8K - 14K", style = TextStyle(
                        fontSize = 10.sp,
                    )
                )
            }
            Text(
                text = "Estimated arrival 3 days",
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
        Button(
            onClick = {
                if(selectedUkuran?.ukuran != null && selectedWarna?.warna !=null){
                    navigateToPayment(id,selectedUkuran?.ukuran.toString(),selectedWarna?.warna.toString())
                }else{
                    showSnackbar("Required choose Size and Colour")
                }
                         },
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = "Buy", style = TextStyle(fontWeight = FontWeight.Bold, color = Color.White))
        }
    }
}

@Composable
fun boxSelected (
    Option : String,
    isSelected: Boolean,
    onClick:()->Unit
){
    Box(modifier = Modifier
        .padding(5.dp)
        .border(width = 1.dp, color = Color.Black, RoundedCornerShape(5.dp))
        .clip(shape = RoundedCornerShape(5.dp))
        .background(if (isSelected) Color(0XFF4682A9) else Color.White)
        .clickable{onClick()}
    ){
        Text(
            text=Option,
            style= TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = (if(isSelected) Color.White else Color.Black)
            ),
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

//@Preview (showBackground = true)
//@Composable
//fun prevDetailContent (){
//    EyeCareAppTheme {
//        DetailContent(
//            navigateToPayment ={},
//            navigateBack = {},
//            checked = false,
//            unChecked = {},
//            isChecked = {},
//            id = 1,
//            title = "test",
//            image="test",
//            type="test",
//            price="test",
//            showSnackbar = {}
//        )
//    }
//}