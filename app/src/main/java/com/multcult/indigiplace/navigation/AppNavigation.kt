package com.multcult.indigiplace.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.multcult.indigiplace.ui.screen.*
import com.multcult.indigiplace.viewmodel.ProductViewModel

@Composable
fun AppNavigation(navController: NavHostController) {  // Removido 'modifier'
    val productViewModel: ProductViewModel = viewModel()

    NavHost(navController, startDestination = "sign_in") {
        composable("sign_in") {
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
        }
    }
}