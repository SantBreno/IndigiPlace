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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.multcult.indigiplace.model.Product
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
    ) { innerPadding ->  // Captura o content padding
        LazyColumn(
            contentPadding = innerPadding,  // Aplica o padding do Scaffold
            modifier = Modifier.padding(horizontal = 16.dp)  // Padding lateral adicional, se quiser
        ) {
            items(viewModel.productList.size) { index ->
                val product = viewModel.productList[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { navController.navigate("details/${product.id}") }
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(product.imageUrl),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
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
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val fakeProducts = listOf(
        Product(1, "Colar", 100.0, "Arte", "Feito à mão", "https://www.crefito8.gov.br/portal/images/phocagallery/galeria2/thumbs/phoca_thumb_l_image04_grd.png"),
        Product(2, "Colar", 50.0, "Acessório", "Colar indígena", "https://via.placeholder.com/150")
    )

    val fakeViewModel = object : ProductViewModel() {
        init {
            productList.addAll(fakeProducts)
        }
    }

    val fakeNavController = rememberNavController()

    HomeScreen(navController = fakeNavController, viewModel = fakeViewModel)
}
