package com.example.eyecareapp.ui.components.content

import Alert
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.common.InputPassword
import com.example.eyecareapp.ui.screen.Profile.ProfileViewModel
@Composable
fun ChangeProfileContent(
    navigateBack : () -> Unit,
    viewModel: ProfileViewModel
) {
    var password by remember { mutableStateOf("") }
    var password_confirmation by remember { mutableStateOf("") }
    Box(modifier = Modifier.padding(10.dp)){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
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
                    text = "Change Profile",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription ="" ,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(15.dp))
            InputPassword(
                icon = Icons.Default.Lock,
                label = "Password",
                placeholder = "New Password",
                onValueChange = {password = it}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            InputPassword(
                icon = Icons.Default.Lock,
                label = "Re-Password",
                placeholder = "Confirmation Password",
                onValueChange = {password_confirmation = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(
                onClick = {
                    viewModel.changePassword(password, password_confirmation)
//                    when (viewModel.uiState.value) {
//
//                        is UiState.Loading -> {}
//                        is UiState.Success->{
//                            val data = (viewModel.uiState.value as UiState.Success).data
//                        }
//                        is UiState.Error->{
//
//                        }
//                    }
                },
                modifier = Modifier
                    .width(140.dp),
                shape = RoundedCornerShape(5.dp),

                ) {
                Text(text = "Simpan")
            }
        }
    }
    viewModel.uiState.collectAsState(
        initial = UiState.Loading
    ).value.let {
        state->when(state){
            is UiState.Loading->{}
            is UiState.Success->{
                if(state.data.status == "success"){
                    Alert(title = "Success", message =state.data?.message.toString() , icon =Icons.Default.Check , tint = Color.Green )
                }else{
                    Alert(title = "Failed", message =state.data?.message.toString() , icon =Icons.Default.Warning , tint = Color.Red )
                }
            }
            is UiState.Error->{}
        }
    }
}

//@Preview (showBackground = true)
//@Composable
//fun prevChangeProfileContent(){
//    EyeCareAppTheme {
//        ChangeProfileContent(
//            navigateBack = {}
//        )
//    }
//}