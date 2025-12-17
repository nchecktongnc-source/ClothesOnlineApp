package com.example.clothesonlineapp.data.repository

import com.example.clothesonlineapp.data.source.DummyData
import com.example.clothesonlineapp.model.Product

class ProductRepository {

    fun getProducts(): List<Product> {
        return DummyData.getProducts()
    }
}
