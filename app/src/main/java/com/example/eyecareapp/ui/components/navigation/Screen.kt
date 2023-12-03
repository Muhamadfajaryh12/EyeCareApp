package com.example.eyecareapp.ui.components.navigation

sealed class Screen(val route:String){
    object login:Screen("Login")
    object register:Screen("Register")
    object home:Screen("Home")
    object test:Screen("Test")
    object blindcolour:Screen("Test/BlindColour")
    object hypomia:Screen("Test/Hypomia")
    object result:Screen("Result")
    object cart:Screen("Cart")
    object payment:Screen("Cart/Payment")
    object profile:Screen("Profile")
    object detail:Screen("Home/Detail")
    object changeprofile:Screen("Profile/Change")

}
