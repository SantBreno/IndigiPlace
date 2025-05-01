package com.multcult.indigiplace.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.multcult.indigiplace.model.Product

class ProductViewModel : ViewModel() {
    private var nextId = 1
    val productList = mutableStateListOf<Product>()

    fun addProduct(product: Product) {
        productList.add(product.copy(id = nextId++))
    }

    fun getProductById(id: Int): Product? {
        return productList.find { it.id == id }
    }
}