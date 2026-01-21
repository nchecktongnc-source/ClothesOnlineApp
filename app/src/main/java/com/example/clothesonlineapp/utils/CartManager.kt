package com.example.clothesonlineapp.utils

import com.example.clothesonlineapp.model.CartItem
import com.example.clothesonlineapp.model.Product

object CartManager {

    private val cartItems = mutableListOf<CartItem>()

    fun add(product: Product) {
        val existing = cartItems.find { it.product.name == product.name }
        if (existing != null) {
            existing.qty++
        } else {
            cartItems.add(CartItem(product, 1))
        }
    }

    fun increase(item: CartItem) {
        item.qty++
    }

    fun decrease(item: CartItem) {
        if (item.qty > 1) {
            item.qty--
        } else {
            cartItems.remove(item)
        }
    }

    fun remove(item: CartItem) {
        cartItems.remove(item)
    }

    fun clear() {
        cartItems.clear()
    }

    fun getItems(): List<CartItem> = cartItems

    fun getTotal(): Double =
        cartItems.sumOf { it.product.price * it.qty }
}