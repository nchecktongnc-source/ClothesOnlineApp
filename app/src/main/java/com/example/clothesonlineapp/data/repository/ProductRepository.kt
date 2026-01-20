package com.example.clothesonlineapp.data.repository

import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.data.model.Product

object ProductRepository {

    fun getProducts(): List<Product> {
        return listOf(
            Product("Jacket", 49.99, R.drawable.jacket),
            Product("Jeans", 39.99, R.drawable.jeans),
            Product("T-Shirt", 19.99, R.drawable.tshirt)
        )
    }
}