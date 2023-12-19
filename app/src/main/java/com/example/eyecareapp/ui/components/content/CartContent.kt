package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.common.OrderCard
import com.example.eyecareapp.ui.components.common.WishlistCard
import com.example.eyecareapp.ui.screen.Cart.CartViewModel

@Composable
fun CartContent (
    viewModel: CartViewModel,
    navigateToDetail:(Int) -> Unit
) {
    Column (
        modifier = Modifier
            .padding(10.dp)
    ){
        Text(
            text = "Order Cart",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        viewModel.orderState.collectAsState().value.let {
            state-> when(state){
                is UiState.Loading->{
                    viewModel.getAllOrder()
                }
                is UiState.Success->{
                    LazyColumn(
                        modifier=Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        items(state.data){
                            data->
                            OrderCard(
                                title = data.title,
                                image = data.image,
                                status = data.status
                            )
                        }
                    }

                }
                is UiState.Error->{}
            }
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Text(
            text = "Wishlist",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        viewModel.uiState.collectAsState().value.let {
            state-> when(state){
                is UiState.Loading->{
                    viewModel.getAllWishlist()
                }
                is UiState.Success->{
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        items(state.data){ data ->
                            WishlistCard(
                                title = data.title,
                                image = data.image,
                                price = data.price,
                                navigateToDetail = navigateToDetail,
                                id = data.id
                            )
                        }
                    }
                }
             is UiState.Error->{}
            }
        }
    }
}
