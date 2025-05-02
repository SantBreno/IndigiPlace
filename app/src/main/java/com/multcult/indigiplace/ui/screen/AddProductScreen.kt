package com.multcult.indigiplace.ui.screen


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.multcult.indigiplace.model.Product
import com.multcult.indigiplace.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(navController: NavController, viewModel: ProductViewModel) {
    var title by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Cadastrar Produto") }) }
    ) { innerPadding ->  // <- Captura o padding automático do Scaffold
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {  // Aplica o padding
            OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Título") })
            OutlinedTextField(value = price, onValueChange = { price = it }, label = { Text("Preço") })
            OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Descrição") })
            OutlinedTextField(value = category, onValueChange = { category = it }, label = { Text("Categoria") })
            OutlinedTextField(value = imageUrl, onValueChange = { imageUrl = it }, label = { Text("URL da Imagem") })
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                viewModel.addProduct(
                    Product(
                        id = 0, // será sobrescrito no ViewModel
                        title = title,
                        price = price.toDoubleOrNull() ?: 0.0,
                        category = category,
                        description = description,
                        imageUrl = imageUrl
                    )
                )
                navController.popBackStack()
            }) {
                Text("Cadastrar Produto")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddProductScreenPreview() {
    val navController = rememberNavController()
    val fakeViewModel = ProductViewModel()
    AddProductScreen(navController = navController, viewModel = fakeViewModel)
}
