package com.example.clothesonlineapp.utils

import com.example.clothesonlineapp.model.Product

object CartManager {

    private val cartItems = mutableListOf<Product>()

    fun addToCart(product: Product) {
        cartItems.add(product)
    }

    fun getCartItems(): List<Product> {
        return cartItems
    }

    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.price }
    }

    fun clearCart() {
        cartItems.clear()
    }
}
