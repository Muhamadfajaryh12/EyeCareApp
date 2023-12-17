package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.components.common.InputWithIcon
import com.example.eyecareapp.ui.theme.EyeCareAppTheme
@Composable
fun ChangeProfileContent(
    navigateBack : () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password_confirmation by remember { mutableStateOf("") }
    Box(modifier = Modifier.padding(10.dp)){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .clickable { navigateBack() }
                )
                Text(
                    text="Change Profile",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
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
            Spacer(modifier = Modifier.padding(5.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(100.dp),
                shape = RoundedCornerShape(5.dp)
                ) {
                Text(
                    text="File",
                    style = TextStyle(
                        fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    )
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            InputWithIcon(
                icon = Icons.Default.Email,
                label = "Email Address",
                placeholder = "Masukkan Email Anda",
                onValueChange = {email = it}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            InputWithIcon(
                icon = Icons.Default.Person,
                label = "Username",
                placeholder = "Masukkan Username Anda",
                onValueChange = {username = it}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            InputWithIcon(
                icon = Icons.Default.Lock,
                label = "Password",
                placeholder = "Masukkan Password Baru Anda",
                onValueChange = {password = it}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            InputWithIcon(
                icon = Icons.Default.Lock,
                label = "Re-Password",
                placeholder = "MAsukkan Kembali Password Baru Anda",
                onValueChange = {password_confirmation = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Button(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(140.dp),
                shape = RoundedCornerShape(5.dp),

                ) {
                Text(text = "Simpan")
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun prevChangeProfileContent(){
    EyeCareAppTheme {
        ChangeProfileContent(
            navigateBack = {}
        )
    }
}