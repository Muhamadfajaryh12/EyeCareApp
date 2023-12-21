package com.example.eyecareapp.ui.components.content

import InputNumber
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.data.OrderGlassData
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.common.InputAddress
import com.example.eyecareapp.ui.screen.Payment.PaymentViewModel

@Composable
fun PaymentContent(
    id:Int,
    title:String,
    image:String,
    ukuran:String,
    warna:String,
    type:String,
    price:String,
    viewModel: PaymentViewModel,
    navigateBack:()->Unit,
    navigateToCart:()->Unit,
    showSnackBar:(String)->Unit,
    ) {
    var selectedBank by remember { mutableStateOf<BankInfo?>(null) }
    var accountNumber by remember { mutableStateOf("") }
    var address by remember{ mutableStateOf("") }
    val lifecycleOwner = LocalLifecycleOwner.current
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .background(Color.White),
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
                text = "Payment",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
        }

        PaymentCategory("Bank Transactions", dummyBank, selectedBank) { bank ->
            selectedBank = bank
        }
        Spacer(modifier = Modifier.padding(5.dp))

        PaymentCategory("Virtual Transactions", dummyMBank, selectedBank) { bank ->
            selectedBank = bank
        }

        Spacer(modifier = Modifier.padding(5.dp))

        PaymentCategory("Cash Transactions", dummyCOD, selectedBank) { bank ->
            selectedBank = bank
        }
        Spacer(modifier = Modifier.padding(5.dp))

        InputNumber(
            icon = Icons.Default.Info,
            placeholder = "Account number",
            label = "Account number" ,
            onValueChange = {accountNumber = it}
        )

        InputAddress(
            placeholder = "Enter your address",
            label = "Address" ,
            onValueChange ={address = it},
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            onClick ={
                if(address != ""){
                                viewModel.addOrder(
                                        OrderGlassData(
                                        id,
                                        title,
                                        image,
                                        ukuran,
                                        warna,
                                        selectedBank?.name.toString(),
                                        "In Delivery",
                                        accountNumber,
                                        address,
                                        type,
                                        price
                                        )
                                ).observe(lifecycleOwner){
                                    order-> when(order){
                                        is UiState.Loading->{}
                                        is UiState.Success->{
                                            if(order.data == "Success"){
                                                navigateToCart()
                                            }
                                        }
                                        is UiState.Error->{}
                                    }
                                }
                           }else{
                               showSnackBar("Address required")
                }
                     },
                    modifier= Modifier.width(300.dp)
        ) {
            Text(text = "Confirm")
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
            .height(45.dp)
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
