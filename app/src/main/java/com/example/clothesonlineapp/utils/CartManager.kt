package com.example.clothesonlineapp.utils

import com.example.clothesonlineapp.model.CartItem
import com.example.clothesonlineapp.model.Product

object CartManager {

    private val items = mutableListOf<CartItem>()

    fun add(product: Product) {
        val found = items.find { it.product.name == product.name }
        if (found != null) {
            found.qty++
        } else {
            items.add(CartItem(product, 1))
        }
    }

    fun increase(item: CartItem) {
        item.qty++
    }

    fun decrease(item: CartItem) {
        if (item.qty > 1) item.qty--
        else items.remove(item)
    }

    fun getItems(): MutableList<CartItem> = items

    fun totalPrice(): Double =
        items.sumOf { it.product.price * it.qty }

    fun clear() {
        items.clear()
    }
}