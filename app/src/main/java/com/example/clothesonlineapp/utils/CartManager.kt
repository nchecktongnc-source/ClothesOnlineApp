package com.example.clothesonlineapp.utils

import com.example.clothesonlineapp.model.CartItem
import com.example.clothesonlineapp.model.Product

object CartManager {

    private val items = mutableListOf<CartItem>()

    fun add(product: Product) {
        val existing = items.find { it.product.name == product.name }
        if (existing != null) {
            existing.qty++
        } else {
            items.add(CartItem(product))
        }
    }

    fun increase(item: CartItem) {
        item.qty++
    }

    fun decrease(item: CartItem) {
        if (item.qty > 1) {
            item.qty--
        } else {
            items.remove(item)
        }
    }

    fun clear() {
        items.clear()
    }

    fun getItems(): MutableList<CartItem> = items

    fun getTotalPrice(): Double =
        items.sumOf { it.product.price * it.qty }

    fun getCount(): Int =
        items.sumOf { it.qty }
}