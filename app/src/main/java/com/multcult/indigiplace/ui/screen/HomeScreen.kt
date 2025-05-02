package com.multcult.indigiplace.ui.screen


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    var selectedCategory by remember { mutableStateOf("") } // Categoria selecionada
    val categories = listOf("Arte", "Acessório", "Decoração", "Roupas", "Alimentos")

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
                .background(Color(0xFFF4ECDC))
        ) {
            BannerSection()

            // Exibindo os filtros de categoria
            CategorySelector(
                categories = categories,
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )

            // Filtrando e exibindo os produtos
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                val filteredProducts = if (selectedCategory.isNotEmpty()) {
                    productList.filter { it.category == selectedCategory }
                } else {
                    productList // Exibe todos os produtos se nenhuma categoria for selecionada
                }

                items(filteredProducts.size) { index ->
                    val product = filteredProducts[index]
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        border = BorderStroke(2.dp, Color(0XFF452A19)),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable { onProductClick(product) }
                    ) {
                        Row(Modifier.padding(8.dp)) {
                            Image(
                                painter = rememberAsyncImagePainter(product.imageUrl),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(60.dp)
                                    .clip(RoundedCornerShape(16.dp))
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(modifier = Modifier.weight(1f)){
                                Text(product.title, style = MaterialTheme.typography.titleMedium)
                                Text(product.category, style = MaterialTheme.typography.bodySmall)
                            }

                            Text("R$ ${product.price}",
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier.align(Alignment.CenterVertically))
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
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
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

@Composable
fun CategorySelector(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        categories.forEach { category ->
            val isSelected = category ==selectedCategory
            FilterChip(
                colors = FilterChipDefaults.filterChipColors(Color.White),
                border = BorderStroke(1.dp, Color(0XFF452A19)),
                selected = isSelected,
                onClick = { onCategorySelected(category) },
                label = { Text(category) },
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)

            )

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
