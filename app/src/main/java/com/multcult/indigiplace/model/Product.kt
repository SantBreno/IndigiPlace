package com.multcult.indigiplace.model

data class Product(
    val id: Int,
    val title: String,
    val category: String,
    val price: Double,
    val description: String,
    val imageUrl: String
)