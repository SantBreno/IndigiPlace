package com.multcult.indigiplace.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.multcult.indigiplace.viewmodel.ProductViewModel
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(productId: Int, viewModel: ProductViewModel) {
    val product = viewModel.getProductById(productId) ?: return

    Scaffold(
        topBar = { TopAppBar(title = { Text(product.title) }) },
        bottomBar = {
            Button(
                onClick = { /* Implementar lógica de compra */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Finalizar Compra")
            }
        }
    ) { innerPadding -> // <- Captura o padding automático do Scaffold
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) { // Aplica o padding
            Image(
                painter = rememberAsyncImagePainter(product.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("R$ ${product.price}", style = MaterialTheme.typography.titleMedium)
            Text("Categoria: ${product.category}")
            Text(product.description)
        }
    }
}
