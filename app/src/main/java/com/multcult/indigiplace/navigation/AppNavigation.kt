package com.multcult.indigiplace.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.multcult.indigiplace.ui.screen.*
import com.multcult.indigiplace.viewmodel.AuthViewModel
import com.multcult.indigiplace.viewmodel.ProductViewModel

@Composable
fun AppNavigation(modifier : Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    val productViewModel: ProductViewModel = viewModel()

    NavHost(navController = navController, startDestination = "signin", builder = {
        composable("signin") {
            SignInScreen(modifier, navController, authViewModel)
        }
        composable("sign_up") {
            SignUpScreen(modifier, navController, authViewModel)
        }
        composable("home") {
            HomeScreen(modifier, navController, authViewModel)
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
    } )
}

