package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DetailOrderContent (
    title:String,
    image:String,
    price:String,
    type:String,
    address:String,
    ukuran:String,
    warna:String,
    status:String,
    payment:String,
    account:String,
    navigateBack:()->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(Color.White)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
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
                text = "Detail Order",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
        }
        Spacer(modifier = Modifier.padding(5.dp))
        AsyncImage(model = image, contentDescription = title, modifier = Modifier
            .width(300.dp)
            .height(300.dp))
        Spacer(modifier = Modifier.padding(5.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = "Item Detail",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
            .border(2.dp, Color.Gray)
            .padding(5.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text="Item Name :")
            Text(text = title)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text="Item Type : ")
            Text(text = type)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text="Item Size : ")
            Text(text = ukuran)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text="Item Color : ")
            Text(text = warna)
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = "Payment",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
            .border(2.dp, Color.Gray)
            .padding(5.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Payment path : ")
            Text(text = payment)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text="Payment account : ")
            Text(text = account)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Address location : ")
            Text(text = address)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text="Status :")
            Text(text = status)
        }
        Spacer(modifier = Modifier.padding(10.dp))

        Spacer(modifier = Modifier
            .height(2.dp)
            .fillMaxWidth()
            .border(2.dp, Color.Gray)
            .padding(5.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text="Total : ", fontWeight = FontWeight.Bold)
            Text(text = price)
        }
    }
}