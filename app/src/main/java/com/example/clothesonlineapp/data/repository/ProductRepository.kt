package com.example.clothesonlineapp.data.repository

import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.data.model.Product

object ProductRepository {

    fun getProducts(): List<Product> {
        return listOf(
            Product("T-Shirt", 19.99, R.drawable.ic_launcher_foreground),
            Product("Jacket", 49.99, R.drawable.ic_launcher_foreground),
            Product("Shoes", 79.99, R.drawable.ic_launcher_foreground),
            Product("Cap", 14.99, R.drawable.ic_launcher_foreground)
        )
    }
}