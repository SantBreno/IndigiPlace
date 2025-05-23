package com.multcult.indigiplace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.multcult.indigiplace.navigation.AppNavigation
import com.multcult.indigiplace.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        setContent {
            Scaffold(modifier = Modifier) { innerPadding ->
                AppNavigation(
                    modifier = Modifier.padding(innerPadding),
                    authViewModel = authViewModel
                )
            }
        }
    }
}
