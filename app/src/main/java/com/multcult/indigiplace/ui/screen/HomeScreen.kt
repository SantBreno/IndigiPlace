package com.multcult.indigiplace.ui.screen


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.multcult.indigiplace.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier, navController: NavHostController, authViewModel: AuthViewModel) {
   /* HomeScreenContent(
        productList = viewModel.productList,
        onProductClick = { product -> navController.navigate("details/${product.id}") },
        onAddClick = { navController.navigate("add") }
    )*/
}

/*@OptIn(ExperimentalMaterial3Api::class)
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
}*/
