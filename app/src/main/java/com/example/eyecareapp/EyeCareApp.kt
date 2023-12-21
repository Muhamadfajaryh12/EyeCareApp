package com.example.eyecareapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.eyecareapp.ui.components.navigation.Screen
import com.example.eyecareapp.ui.components.navigation.bottomBar.BottomBar
import com.example.eyecareapp.ui.screen.Cart.CartScreen
import com.example.eyecareapp.ui.screen.Cart.Detail.OrderDetail
import com.example.eyecareapp.ui.screen.Detail.DetailScreen
import com.example.eyecareapp.ui.screen.Detail.Payment.PaymentScreen
import com.example.eyecareapp.ui.screen.Home.HomeScreen
import com.example.eyecareapp.ui.screen.Login.LoginScreen
import com.example.eyecareapp.ui.screen.Profile.ChangeProfileScreen
import com.example.eyecareapp.ui.screen.Profile.ProfileScreen
import com.example.eyecareapp.ui.screen.Register.RegisterScreen
import com.example.eyecareapp.ui.screen.Test.ColourBlind.ColourBlindScreen
import com.example.eyecareapp.ui.screen.Test.Hypomia.HypomiaScreen
import com.example.eyecareapp.ui.screen.Test.Result.ResultScreen
import com.example.eyecareapp.ui.screen.Test.TestScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EyeCareApp (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){


    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    showBottomBar = when (navBackStackEntry?.destination?.route) {
        "Home/{id}" -> false
        "Payment/{id}/{ukuran}/{warna}" -> false
        "Profile/Change" -> false
        "Test/BlindColour" -> false
        "Test/Hypomia" -> false
        "Register" -> false
        "Login"-> false
        "Order/{id}"->false
        "Test/BlindColour/{id}"-> false
        else -> true
    }

    Scaffold (
            bottomBar = {
                    if(showBottomBar){
                        BottomBar(navController = navController)
                    }
            },
            modifier = modifier
    ){
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.login.route){
                LoginScreen(
                    navigateToRegister = {
                        navController.navigate(Screen.register.route)
                    }
                ) {
                    navController.navigate(Screen.home.route)
                }
            }
            composable(Screen.register.route){
                RegisterScreen(
                    navigateToLogin = {
                        navController.navigate(Screen.login.route)
                    }
                )
            }
            composable(Screen.home.route){
                HomeScreen(
                    navigateToDetail = {
                        id -> navController.navigate(Screen.detail.createRoute(id))
                    },
                    navigateToLogin = {
                        navController.navigate(Screen.login.route)
                    }
                )
            }
            composable(Screen.test.route){
                TestScreen(
                        navigateToHypomiaTest = {
                            navController.navigate(Screen.hypomia.route)
                        },
                        navigateToColourBlindTest = {
                            navController.navigate(Screen.blindcolour.route)
                        }
                )
            }
            composable(Screen.hypomia.route){
                HypomiaScreen(
                    navigateToResult = {
                        navController.navigate(Screen.result.route)
                    }
                )
            }
            composable(Screen.blindcolour.route){
                ColourBlindScreen(
                    navigateToResult = { id ->
                        navController.navigate(Screen.result.createRoute(id))
                    },
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(
                route = Screen.result.route,
                arguments = listOf(
                    navArgument("id"){type = NavType.StringType},
                )
            ){
                val id = it.arguments?.getString("id")
                ResultScreen(id as String,
                    navigateToDetail = {id->
                        navController.navigate(Screen.detail.createRoute(id))
                    },
                    navigateBack = {navController.navigate(Screen.home.route)}
                )
            }
            composable(
                route = Screen.detail.route,
                arguments = listOf(navArgument("id"){
                    type = NavType.IntType
                })
                ){
                val id = it.arguments?.getInt("id")?:-1L
                DetailScreen( id = id as Int,
                    navigateToPayment = { id,ukuran,warna->
                        navController.navigate(Screen.payment.createRoute(id,ukuran,warna))
                    },
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
            composable(
                route = Screen.detailorder.route,
                arguments = listOf(navArgument("id"){
                    type = NavType.IntType
                })
            ){
                val id = it.arguments?.getInt("id")?:-1L
                OrderDetail( id = id as Int,
                    navigateBack = {
                    navController.navigateUp()
                })
            }

            composable(Screen.profile.route){
                ProfileScreen(
                    navigateToChangeProfile = {
                        navController.navigate(Screen.changeprofile.route)
                    },
                    navigateToLogin = {
                        navController.navigate(Screen.login.route)
                    }
                )
            }
            composable(Screen.cart.route){
                CartScreen(
                    navigateToDetail = {
                            id -> navController.navigate(Screen.detail.createRoute(id))
                    },
                    navigateToOrder = {
                        id->navController.navigate(Screen.detailorder.createRoute(id))
                    }
                )
            }
            composable(
                route = Screen.payment.route,
                arguments = listOf(
                    navArgument("id"){type = NavType.IntType},
                   navArgument("ukuran"){type= NavType.StringType},
                    navArgument("warna"){type = NavType.StringType}
                )
            ){
                val id = it.arguments?.getInt("id")?: -1L
                val ukuran = it.arguments?.getString("ukuran") ?: ""
                val warna = it.arguments?.getString("warna") ?: ""

                PaymentScreen(id = id as Int,
                    ukuran=ukuran,
                    warna=warna,
                    navigateBack = {
                        navController.navigateUp()
                    },
                    navigateToCart = {
                        navController.navigate(Screen.home.route)
                    }
                )
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


