package com.multcult.indigiplace.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.multcult.indigiplace.ui.screen.*
import com.multcult.indigiplace.viewmodel.AuthViewModel

@Composable
fun AppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    /*val productViewModel: ProductViewModel = viewModel()*/

    NavHost(navController = navController, startDestination = "sign_in", builder = {
        composable("sign_in") {
            SignInScreen(modifier, navController)
        }
        composable("sign_up") {
            SignUpScreen(modifier, navController, authViewModel)
        }
        composable("home") {
            HomeScreen()
        }
    })
        /*composable("sign_in") {
            SignInScreen(
                onSignInSuccess = { navController.navigate("home") },
                onSignUpClick = { navController.navigate("sign_up") }
            )
        }
        composable("sign_up") {
            SignUpScreen(onSignUpSuccess = { navController.navigate("sign_in") })
        }
        composable("home") {
            HomeScreen(navController, productViewModel)
        }
        composable("details/{productId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            id?.let {
                ProductDetailScreen(productId = it, viewModel = productViewModel)
            }
        }
        composable("add") {
            AddProductScreen(navController, productViewModel)
        }*/

}