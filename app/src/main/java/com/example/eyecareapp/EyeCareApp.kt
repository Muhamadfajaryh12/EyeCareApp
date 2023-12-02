package com.example.eyecareapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eyecareapp.ui.components.navigation.Screen
import com.example.eyecareapp.ui.components.navigation.bottomBar.BottomBar
import com.example.eyecareapp.ui.screen.Cart.CartScreen
import com.example.eyecareapp.ui.screen.Detail.DetailScreen
import com.example.eyecareapp.ui.screen.Home.HomeScreen
import com.example.eyecareapp.ui.screen.Profile.ChangeProfileScreen
import com.example.eyecareapp.ui.screen.Profile.ProfileScreen
import com.example.eyecareapp.ui.screen.Test.TestScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EyeCareApp (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    Scaffold (
        bottomBar ={
            BottomBar(navController = navController)
        },
        modifier = modifier
    ){
        innerPadding ->
        NavHost(navController = navController, startDestination = Screen.home.route, modifier = Modifier.padding(innerPadding) ){
            composable(Screen.home.route){
                HomeScreen(
                    navigateToDetail = {
                        navController.navigate(Screen.detail.route)
                    }
                )
            }
            composable(Screen.test.route){
                TestScreen()
            }
            composable(Screen.detail.route){
                DetailScreen()
            }
            composable(Screen.profile.route){
                ProfileScreen(
                    navigateToChangeProfile = {
                        navController.navigate(Screen.changeprofile.route)
                    }
                )
            }
            composable(Screen.cart.route){
                CartScreen()
            }
            composable(Screen.changeprofile.route){
                ChangeProfileScreen(
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }

}