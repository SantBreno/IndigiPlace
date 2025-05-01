package com.multcult.indigiplace.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.multcult.indigiplace.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: ProductViewModel) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mercado Indígena") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("add") }) {
                Text("+")
            }
        }
    ) { innerPadding -> // <- Captura o padding automático do Scaffold
        LazyRow(modifier = Modifier
            .padding(innerPadding) // <- Aplica o padding do Scaffold
            .padding(horizontal = 16.dp, vertical = 8.dp) // <- Seu padding adicional, se quiser
        ) {
            items(viewModel.productList.size) { index ->
                val product = viewModel.productList[index]
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(8.dp)
                        .clickable { navController.navigate("details/${product.id}") }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(product.imageUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                        )
                        Text(product.title, style = MaterialTheme.typography.titleMedium)
                        Text("R$ ${product.price}")
                        Text(product.category)
                    }
                }
            }
        }
    }
}
