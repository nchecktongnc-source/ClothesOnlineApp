package com.example.clothesonlineapp.data.repository

import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.model.Product

object ProductRepository {

    fun getProducts(): List<Product> {
        return listOf(
            Product("T-Shirt", 20.0, R.drawable.ic_launcher_foreground),
            Product("Hoodie", 35.0, R.drawable.ic_launcher_foreground),
            Product("Jeans", 40.0, R.drawable.ic_launcher_foreground)
        )
    }
}