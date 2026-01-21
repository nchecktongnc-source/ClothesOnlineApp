package com.example.clothesonlineapp.model

data class CartItem(
    val product: Product,
    var qty: Int = 1
)