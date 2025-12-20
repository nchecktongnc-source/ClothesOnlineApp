package com.example.clothesonlineapp.data.source

import com.example.clothesonlineapp.R
import com.example.clothesonlineapp.model.Product

object DummyData {

    fun getProducts(): List<Product> {
        return listOf(
            Product(1, "tshirt", 15.0, R.drawable.tshirt),
            Product(2, "jacket", 45.0, R.drawable.jacket),
            Product(3, "jeans", 30.0, R.drawable.jeans)
        )
    }
}
