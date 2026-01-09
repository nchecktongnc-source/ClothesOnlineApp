package com.example.clothesonlineapp.data.source

import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.model.Product

object DummyData {

    fun getProducts(): List<Product> {
        return listOf(
            Product("Jacket", 49.99, R.drawable.jacket),
            Product("T-Shirt", 19.99, R.drawable.tshirt),
            Product("Jeans", 39.99, R.drawable.jeans)
        )
    }
}
