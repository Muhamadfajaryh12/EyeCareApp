package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R

@Composable
fun PaymentContent () {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier){
            Text(text = "Transaksi Bank",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            LazyColumn(){
                items(dummyBank){
                        bank ->
                    rowPayment(name = bank.name, image =bank.imageResId )
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(modifier = Modifier){
            Text(text = "Transaksi Virtual",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            LazyColumn(){
                items(dummyMBank){
                        bank ->
                    rowPayment(name = bank.name, image =bank.imageResId )
                }
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Column(modifier = Modifier){
            Text(text = "Transaksi Tunai",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            LazyColumn(){
                items(dummyCOD){
                        bank ->
                    rowPayment(name = bank.name, image =bank.imageResId )
                }
            }
        }
    }
}

@Composable
fun rowPayment(
    name : String,
    image :Int
){
    Spacer(modifier = Modifier.padding(3.dp))
    Row(  modifier = Modifier
        .width(300.dp)
        .shadow(elevation = 1.dp)
        .height(50.dp)
        .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = name)
        Image(
            painter = painterResource(id = image),
            contentDescription ="",
            modifier = Modifier
                .height(20.dp)
                .width(60.dp)
        )
    }
}
data class BankInfo(val name: String, val imageResId: Int)
val dummyBank = listOf(
    BankInfo("Bank Central Asia", R.drawable.bca),
    BankInfo("Bank Tabungan Negara", R.drawable.btn)
)
val dummyMBank = listOf(
    BankInfo("Gopay" , R.drawable.gopay),
    BankInfo("OVO",R.drawable.ovo),
    BankInfo("Dana",R.drawable.dana)
)
val dummyCOD = listOf(
    BankInfo("Cash On Delivery",R.drawable.cod)
)
