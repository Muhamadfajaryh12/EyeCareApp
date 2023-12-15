package com.example.eyecareapp.ui.components.navigation.bottomBar

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.eyecareapp.R
import com.example.eyecareapp.ui.components.navigation.NavigationItem
import com.example.eyecareapp.ui.components.navigation.Screen

@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomBar (
    navController: NavController,
    modifier: Modifier = Modifier
){
    NavigationBar (
        modifier = modifier,
        containerColor = Color.White
        ) {
        val navigationItem = listOf(
            NavigationItem(
                title = stringResource(R.string.nav_home),
                icon =  Icons.Default.Home,
                screen = Screen.home
            ),
            NavigationItem(
                title = stringResource(R.string.nav_test),
                icon = Icons.Default.PlayArrow,
                screen = Screen.test
            ),
            NavigationItem(
                title = stringResource(R.string.nav_cart),
                icon = Icons.Default.ShoppingCart,
                screen = Screen.cart
            ),
            NavigationItem(
                title = stringResource(R.string.nav_profile),
                icon = Icons.Default.Person,
                screen = Screen.profile
            )
        )
        navigationItem.map {
            NavigationBarItem(
                selected =false,
                onClick = {
                    navController.navigate(it.screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title,
                        tint = if (navController.currentDestination?.route == it.screen.route) {
                            Color(0XFF4682A9)
                        } else {
                            Color.Black
                        }
                    )
                },
                label ={
                    Text(
                        text = (it.title),
                        color =  if (navController.currentDestination?.route == it.screen.route) {
                            Color(0XFF4682A9)
                        } else {
                            Color.Black
                        }
                    )
                }
            )
        }
    }
}