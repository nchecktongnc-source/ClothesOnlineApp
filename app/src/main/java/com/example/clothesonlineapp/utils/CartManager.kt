package com.example.clothesonlineapp.utils

import com.example.clothesonlineapp.model.Product

object CartManager {

    private val _items = mutableListOf<Product>()

    val items: MutableList<Product>
        get() = _items

    fun addToCart(product: Product) {
        _items.add(product)
    }

    fun removeItem(position: Int) {
        _items.removeAt(position)
    }

    fun getAll(): List<Product> = _items

    fun clear() {
        _items.clear()
    }

    fun totalPrice(): Double {
        return _items.sumOf { it.price }
    }
}
