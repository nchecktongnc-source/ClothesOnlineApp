package com.example.clothesonlineapp.utils

import com.example.clothesonlineapp.data.model.Product

object CartManager {

    private val cartItems = mutableListOf<Product>()

    fun add(product: Product) {
        cartItems.add(product)
    }

    fun getItems(): List<Product> = cartItems

    fun clearCart() {
        cartItems.clear()
    }

    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.price }
    }
}