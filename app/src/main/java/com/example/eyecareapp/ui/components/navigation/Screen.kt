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
    object payment:Screen("Payment/{id}/{ukuran}/{warna}"){
        fun createRoute(id:Int,ukuran:String,warna:String)
        = "Payment/$id/$ukuran/$warna"
    }
    object profile:Screen("Profile")
    object detail:Screen("Home/{id}"){
        fun createRoute(id:Int) = "Home/$id"
    }
    object detailorder:Screen("Order/{id}"){
        fun createRoute(id:Int) = "Order/$id"
    }
    object changeprofile:Screen("Profile/Change")

}
