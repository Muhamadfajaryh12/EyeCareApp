package com.example.eyecareapp.ui.components.content

import android.util.Log
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
    showSnackbar:(String)->Unit
) {
    var selectedWarna by remember { mutableStateOf<Warna?>(null) }
    var selectedUkuran by remember { mutableStateOf<Ukuran?>(null) }
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
                   boxSelected(Option = options.name,
                   isSelected = options == selectedWarna,
                   onClick = {   selectedWarna = if(selectedWarna == options) null else options}
                   )
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
                    boxSelected(
                        Option = options.ukuran,
                        isSelected = options == selectedUkuran,
                        onClick = {  selectedUkuran = if(selectedUkuran == options) null else options}
                    )
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
        Button(onClick = {
            navigateToPayment(id,selectedUkuran?.ukuran.toString(),selectedWarna?.name.toString())
                         Log.d("test",selectedUkuran?.ukuran.toString())
                         Log.d("Test",selectedWarna?.name.toString())
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
data class Warna(val name:String)
data class Ukuran(val ukuran:String)
val optionWarnaDummy = listOf(
    Warna("Biru"),Warna("Merah"),Warna("Hitam")
)
val optionUkuranDummy = listOf(
    Ukuran("-0,50"),Ukuran("-0,75"),Ukuran("-1.00")
)

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