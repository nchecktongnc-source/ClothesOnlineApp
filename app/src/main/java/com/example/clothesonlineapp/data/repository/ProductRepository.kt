package com.example.clothesonlineapp.data.repository

import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.model.Product

object ProductRepository {

    fun getProducts(): List<Product> {
        return listOf(
            Product(
                name = "T-Shirt",
                price = 20.0,
                imageRes = R.drawable.tshirt
            ),
            Product(
                name = "Hoodie",
                price = 35.0,
                imageRes = R.drawable.jacket
            ),
            Product(
                name = "Jeans",
                price = 40.0,
                imageRes = R.drawable.jeans
            )
        )
    }
}