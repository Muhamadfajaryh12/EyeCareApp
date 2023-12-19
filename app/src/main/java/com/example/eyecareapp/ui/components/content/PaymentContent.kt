package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.data.OrderGlassData
import com.example.eyecareapp.ui.screen.Payment.PaymentViewModel

@Composable
fun PaymentContent(
    id:Int,
    title:String,
    image:String,
    ukuran:String,
    warna:String,
    viewModel: PaymentViewModel
) {
    var selectedBank by remember { mutableStateOf<BankInfo?>(null) }
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PaymentCategory("Transaksi Bank", dummyBank, selectedBank) { bank ->
            selectedBank = bank
        }

        Spacer(modifier = Modifier.padding(5.dp))


        PaymentCategory("Transaksi Virtual", dummyMBank, selectedBank) { bank ->
            selectedBank = bank
        }

        Spacer(modifier = Modifier.padding(5.dp))

        PaymentCategory("Transaksi Tunai", dummyCOD, selectedBank) { bank ->
            selectedBank = bank
        }
        Spacer(modifier = Modifier.padding(5.dp))

        Button(onClick ={viewModel.addOrder(OrderGlassData(id,title,image,ukuran,warna,selectedBank?.name.toString(),"Dalam Pengiriman"))} ) {

        }
    }
}

@Composable
fun PaymentCategory(
    categoryTitle: String,
    banks: List<BankInfo>,
    selectedBank: BankInfo?,
    onBankClick: (BankInfo?) -> Unit
) {
    Column {
        Text(
            text = categoryTitle,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        LazyColumn {
            items(banks) { bank ->
                RowPayment(
                    name = bank.name,
                    image = bank.imageResId,
                    isSelected = bank == selectedBank,
                    onClick = { onBankClick(if (selectedBank == bank) null else bank) }
                )
            }
        }
    }
}

@Composable
fun RowPayment(
    name: String,
    image: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Spacer(modifier = Modifier.padding(3.dp))
    Row(
        modifier = Modifier
            .width(300.dp)
            .shadow(elevation = 1.dp)
            .height(50.dp)
            .padding(5.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .border(1.dp, Color.Black, CircleShape)
            .width(20.dp)
            .height(20.dp)
            .background(if (isSelected) Color(0XFF4682A9) else Color.White)
        )
        Text(text = name)
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier
                .height(20.dp)
                .width(60.dp)
                .padding(5.dp)
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
