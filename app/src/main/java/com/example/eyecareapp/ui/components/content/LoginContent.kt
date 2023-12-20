package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.eyecareapp.R
import com.example.eyecareapp.data.preference.UserModel
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.common.InputEmail
import com.example.eyecareapp.ui.components.common.InputPassword
import com.example.eyecareapp.ui.screen.Login.LoginViewModel

@Composable
fun LoginContent (
    navigateToRegister : () -> Unit,
    navigateToHome:()->Unit,
    viewModel:LoginViewModel,
    showSnackBar:(String)->Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val navController = rememberNavController()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(135.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.FillHeight
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.welcome),
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.login),
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = R.drawable.glasses),
            contentDescription = "",
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
        )
        Text(
            text = stringResource(id = R.string.main_name),
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0XFF4682A9)
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputEmail(icon = Icons.Default.Email, placeholder = "Email",label="Email",onValueChange={email = it})
        Spacer(modifier = Modifier.padding(5.dp))
        InputPassword(icon = Icons.Default.Lock, placeholder = "Password", label = "Password" , onValueChange = {password = it} )
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = {
                         viewModel.login(email,password).observe(lifecycleOwner){
                             user-> when(user){
                                 is UiState.Loading->{}
                                is UiState.Success->{
                                    if(user.data.status == "success"){
                                        viewModel.saveSession(UserModel(user.data?.data?.id.toString(),user.data.token.toString()))
                                        navigateToHome()
                                    }
                                    else{
                                        showSnackBar(user.data.message.toString())

                                    }
                                }
                                 is UiState.Error->{
                                     showSnackBar(user.errorMessage)
                                 }
                             }
                         }
        },
            modifier= Modifier
                .width(300.dp),
            shape = RoundedCornerShape(5.dp),
             colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFF4682A9)
            )
        ) {
            Text(
                text = stringResource(id = R.string.login)
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row {
            Text(
                text = stringResource(id = R.string.no_account),
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
            Text(
                text = stringResource(id = R.string.register),
                style = TextStyle(
                    color = Color(0xFF000AFF),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .clickable { navigateToRegister() }
            )
        }
    }
}

