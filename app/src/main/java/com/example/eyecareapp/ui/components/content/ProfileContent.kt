package com.example.eyecareapp.ui.components.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.theme.EyeCareAppTheme


@Composable
fun ProfileContent (
    navigateToChangeProfile : () -> Unit
) {

    Box(modifier = Modifier.padding(10.dp)){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text="Profile",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Image(painter = painterResource(id = R.drawable.profile),
                contentDescription ="" ,
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .clip(CircleShape)
                )
            Spacer(modifier = Modifier.padding(20.dp))
            Box(modifier = Modifier
                .width(300.dp)
                .border(width = 1.dp, color = Color.Black)
            ){
                Text(
                    text = "Lorem Ipsum",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(5.dp)
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Box(modifier = Modifier
                .width(300.dp)
                .border(width = 1.dp, color = Color.Black)
            ){
                Text(
                    text = "Lorem Ipsum",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier.padding(5.dp)
                )
            }
            Spacer(modifier = Modifier.padding(100.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(140.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "Logout",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    )
                }

                Button(
                    onClick = { navigateToChangeProfile() },
                    modifier = Modifier
                        .width(140.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(
                        text = "Settings",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun prevProfileContent () {
    EyeCareAppTheme {
        ProfileContent(
            navigateToChangeProfile = {}
        )
    }
}