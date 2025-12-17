package com.example.clothesonlineapp.data.source

import com.example.clothesonlineapp.model.Product

object DummyData {

    fun getProducts(): List<Product> {
        return listOf(
            Product(1, "T-Shirt", 15.0),
            Product(2, "Jacket", 45.0),
            Product(3, "Jeans", 30.0)
        )
    }
}

