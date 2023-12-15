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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.components.common.InputWithIcon

@Composable
fun RegisterContent (
    navigateToLogin : () -> Unit
) {
    Column(
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
                        text = stringResource(id = R.string.register),
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
            modifier = Modifier.width(120.dp).height(120.dp)
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
        InputWithIcon(
            icon = Icons.Default.Email ,
            placeholder = stringResource(id = R.string.placeholder_email),
            label = stringResource(id = R.string.email)
        )
        Spacer(modifier = Modifier.padding(10.dp))
        InputWithIcon(
            icon = Icons.Default.Person ,
            placeholder = stringResource(id = R.string.placeholder_username),
            label = "Username")
        Spacer(modifier = Modifier.padding(10.dp))
        InputWithIcon(
            icon = Icons.Default.Lock ,
            placeholder = stringResource(id = R.string.placeholder_password),
            label = "Password")
        Spacer(modifier = Modifier.padding(10.dp))

        Button(onClick = {},
            modifier= Modifier
                .width(300.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0XFF4682A9)
            )
        ) {
            Text(
                text = stringResource(id = R.string.register)
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Row {
            Text(
                text = stringResource(id = R.string.have_account),
                style = TextStyle(
                    fontSize = 12.sp
                )
            )
            Text(
                text = stringResource(id = R.string.login),
                style = TextStyle(
                    color = Color(0xFF000AFF),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .clickable { navigateToLogin() }
            )
        }
    }
}