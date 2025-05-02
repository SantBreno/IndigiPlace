package com.multcult.indigiplace.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.multcult.indigiplace.model.Product
import com.multcult.indigiplace.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ProductViewModel
) {
    HomeScreenContent(
        productList = viewModel.productList,
        onProductClick = { product -> navController.navigate("details/${product.id}") },
        onAddClick = { navController.navigate("add") }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    productList: List<Product>,
    onProductClick: (Product) -> Unit,
    onAddClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("IndigiPlace", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            BannerSection()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                items(productList.size) { index ->
                    val product = productList[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { onProductClick(product) }
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
}

@Composable
fun BannerSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFDDEBF7))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Bem-Vindo", style = MaterialTheme.typography.titleLarge)
            Text("Encontre produtos e apoie os povos originários comprando produtos autênticos e de qualidade.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenContentPreview() {
    val fakeProducts = listOf(
        Product(1, "Colar", 100.0, "Arte", "Feito à mão", "https://via.placeholder.com/150"),
        Product(2, "Pulseira", 50.0, "Acessório", "Pulseira indígena", "https://via.placeholder.com/150")
    )

    HomeScreenContent(
        productList = fakeProducts,
        onProductClick = {},
        onAddClick = {}
    )
}
